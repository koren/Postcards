package com.websungroup.postcards.ui.pagerview

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import com.websungroup.postcards.data.Postcard
import com.websungroup.postcards.repository.Repository
import javax.inject.Inject

class PagerViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun getPostcards(postcardGroupId: String): LiveData<List<Postcard>>? {
        val groupId = MutableLiveData<String>()
        groupId.value = postcardGroupId

        return Transformations.switchMap(groupId as LiveData<String>) { postcardGroupId ->
            repository.loadPostcards(postcardGroupId)
        }
    }
}