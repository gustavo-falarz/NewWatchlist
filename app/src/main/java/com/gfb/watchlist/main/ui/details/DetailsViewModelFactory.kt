package com.gfb.watchlist.main.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.gfb.watchlist.main.model.ContentModel

class DetailsViewModelFactory (private val selectedContent: ContentModel) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if ((modelClass.isAssignableFrom(DetailsViewModel::class.java))){
            return DetailsViewModel(selectedContent) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}