package elieoko.me.butterfly.core.store.relational.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import elieoko.me.butterfly.core.store.relational.room.entity.VersionBibleEntity

const val name = "TVersionBibles"
@Dao
interface VersionBibleDao {
    @Query("SELECT * FROM $name")
    fun findAll() : List<VersionBibleEntity>
    @Query("SELECT * FROM $name where id in (:id)")
    fun findById(id : Int) : VersionBibleEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createOrUpdate(data : VersionBibleEntity)
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun saveAll(vararg data: Array<VersionBibleDao>)
}