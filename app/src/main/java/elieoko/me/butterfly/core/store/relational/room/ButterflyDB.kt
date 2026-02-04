package elieoko.me.butterfly.core.store.relational.room

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import elieoko.me.butterfly.core.store.relational.room.dao.VersionBibleDao
import elieoko.me.butterfly.core.store.relational.room.entity.VersionBibleEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import java.util.concurrent.Executors

@Database(
    entities = [VersionBibleEntity::class],
    version = 1,
    exportSchema = false)
abstract class ButterflyDB : RoomDatabase() {
    abstract fun versionBibleDao(): VersionBibleDao
    companion object{
        @Volatile
        private var INSTANCE: ButterflyDB? = null
        fun getDatabase(context: Context, scope: CoroutineScope): ButterflyDB {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ButterflyDB::class.java,
                    "ButterflyDB.db"
                )
                    .setQueryCallback({ sqlQuery, bindArgs ->
                        Log.d("ROOM_SQL", "SQL Query: $sqlQuery SQL Args: $bindArgs")
                    }, Executors.newSingleThreadExecutor())
                    //.addMigrations(migrations = (8,9))
                    //.allowMainThreadQueries()
                    .addCallback(ButterflyDatabaseCallback(scope){INSTANCE})
                    .addCallback(object : Callback() {
                        override fun onOpen(db: SupportSQLiteDatabase) {
                            super.onOpen(db)
                            db.execSQL("PRAGMA foreign_keys=ON")
                            Log.d("DB", "Database opened")
                        }
                    })
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
    private class ButterflyDatabaseCallback(
        private val scope: CoroutineScope,
        private val dbProvider: () -> ButterflyDB?
    ) : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            dbProvider()?.let { database->
                scope.launch {
                    Log.d("*******","test data base")
//                    database.versionBibleDao().createOrUpdate(
//                        VersionBibleEntity(
//                            0,"version Louis Second",1,"SGD","JFD")
//                    )
                    Log.d("*******","save")
//                    database.versionBibleDao().findAll().forEach {
//                        Log.e("data", it.nom)
//                    }
                }
            }
        }
    }

}