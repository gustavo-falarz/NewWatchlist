package com.gfb.watchlist.main.ui.content

import android.app.Application
import androidx.lifecycle.*
import com.gfb.watchlist.main.database.getDatabase
import com.gfb.watchlist.main.model.ContentModel
import com.gfb.watchlist.main.repository.ContentRepository
import kotlinx.coroutines.launch


class ContentListViewModel(application: Application) : AndroidViewModel(application) {

    private val contentRepository = ContentRepository(getDatabase(application))

    val contentList = contentRepository.content

    private val _navigateToContentDetail = MutableLiveData<ContentModel>()
    val navigateToContentDetail: LiveData<ContentModel>
        get() = _navigateToContentDetail

    init {
        getContent()
    }

    private fun getContent() {
        viewModelScope.launch {
            try {
                contentRepository.refreshContent()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun onContentSelected(content: ContentModel) {
        _navigateToContentDetail.value = content
    }

    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ContentListViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ContentListViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct viewmodel")
        }
    }
}