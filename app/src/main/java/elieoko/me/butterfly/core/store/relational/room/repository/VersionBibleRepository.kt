package elieoko.me.butterfly.core.store.relational.room.repository

import androidx.annotation.WorkerThread
import elieoko.me.butterfly.core.store.relational.room.dao.VersionBibleDao
import elieoko.me.butterfly.core.store.relational.room.entity.VersionBibleEntity
import elieoko.me.butterfly.domain.model.bible.VersionBible
import elieoko.me.butterfly.domain.model.bible.toEntity

class VersionBibleRepository(private val dao : VersionBibleDao) {
    @WorkerThread
    fun getAll() = dao.findAll()

    @WorkerThread
    suspend fun save(model : VersionBible){
        dao.createOrUpdate(model.toEntity())
    }

}