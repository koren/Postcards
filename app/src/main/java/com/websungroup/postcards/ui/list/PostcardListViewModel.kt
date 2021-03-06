package com.websungroup.postcards.ui.list

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.databinding.ObservableArrayList
import android.databinding.ObservableField
import com.websungroup.postcards.data.Postcard
import com.websungroup.postcards.repository.Repository
import javax.inject.Inject

class PostcardListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    var adapter = ObservableField<PostcardListAdapter>()
    var data = ObservableArrayList<Postcard>()

    init {
        adapter.set(PostcardListAdapter(PostcardListItemDiffCallback()))
    }

    fun getPostcards(postcardGroupId: String): LiveData<List<Postcard>>? {
        val groupId = MutableLiveData<String>()
        groupId.value = postcardGroupId

        return Transformations.switchMap(groupId as LiveData<String>) { postcardGroupId ->
            repository.loadPostcards(postcardGroupId)
        }
    }
}