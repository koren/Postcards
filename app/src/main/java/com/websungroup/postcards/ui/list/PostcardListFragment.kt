package com.websungroup.postcards.ui.list

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.websungroup.postcards.R
import com.websungroup.postcards.databinding.ListFragmentBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PostcardListFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ListFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.list_fragment,
            container,
            false
        ) as ListFragmentBinding

        initRecyclerView(binding.root)

        return binding.root
    }

    private fun initRecyclerView(view: View) {
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostcardListViewModel::class.java)
//        viewModel.adapter.get()!!.callback = this
        viewModel.prepare()
        binding.viewModel = viewModel
    }

//    fun onLocationSelected(postcard: Postcard) {
//        val intent = PostcardActivity.newIntent(context, location.getPostcardId(), type)
//        startActivity(intent)
//    }
}