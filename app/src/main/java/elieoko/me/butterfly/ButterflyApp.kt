package elieoko.me.butterfly

import android.app.Application
import elieoko.me.butterfly.core.store.relational.room.ButterflyDB
import elieoko.me.butterfly.core.store.relational.room.repository.VersionBibleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

class ButterflyApp : Application(){
    private val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { ButterflyDB.getDatabase(this,applicationScope) }
    val versionBibleRepository by lazy { VersionBibleRepository(database.versionBibleDao()) }

    override fun onCreate() {
        super.onCreate()
        val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)
        val db = ButterflyDB.getDatabase(this, scope)
        // 🔥 Force la création du fichier DB
        db.openHelper.writableDatabase
    }
}