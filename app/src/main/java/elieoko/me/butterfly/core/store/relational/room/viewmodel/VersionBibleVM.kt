package elieoko.me.butterfly.core.store.relational.room.viewmodel

import androidx.lifecycle.*
import elieoko.me.butterfly.core.store.relational.room.entity.VersionBibleEntity
import elieoko.me.butterfly.core.store.relational.room.repository.VersionBibleRepository
import elieoko.me.butterfly.domain.model.bible.VersionBible
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.*

class VersionBibleVM(private val repository: VersionBibleRepository) : ViewModel() {
    private val _listVersionBible = MutableStateFlow<List<VersionBibleEntity>>(arrayListOf())
    val listVersionBible get() = _listVersionBible.asStateFlow()

    fun getAllVersionBible() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            _listVersionBible.value = repository.getAll()
        }
    }

    fun insert(model : VersionBible) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.save(model)
        }
    }
}

class VersionBibleVMFactory(private val repository: VersionBibleRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(VersionBibleEntity::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return VersionBibleVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}