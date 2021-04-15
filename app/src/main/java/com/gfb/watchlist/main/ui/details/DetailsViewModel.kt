package com.gfb.watchlist.main.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gfb.watchlist.main.model.ContentModel

class DetailsViewModel(selectedContent: ContentModel) : ViewModel() {
    private val _content = MutableLiveData<ContentModel>()
    val content: LiveData<ContentModel>
        get() = _content

    init {
        _content.value = selectedContent
    }
}