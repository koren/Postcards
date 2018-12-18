package com.websungroup.postcards.ui.postcard

import android.arch.lifecycle.ViewModel
import com.websungroup.postcards.data.Postcard
import com.websungroup.postcards.repository.Repository
import javax.inject.Inject

class PostcardViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var repository: Repository
    var postcard: Postcard? = null

    fun setPostcard(postcardId: String?) {
        postcard = repository.getPostcard(postcardId)
    }
}