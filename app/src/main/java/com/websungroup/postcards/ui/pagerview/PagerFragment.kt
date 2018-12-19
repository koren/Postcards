package com.websungroup.postcards.ui.pagerview

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.websungroup.postcards.R
import com.websungroup.postcards.ui.postcard.PostcardFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PagerFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: PagerViewModel
    private lateinit var adapter: ViewPagerAdapter

    companion object {
        private const val POSTCARD_GROUP_ID = "POSTCARD_GROUP_ID"

        fun newInstance(postcardGroupId: String): Fragment {
            val fragment = PagerFragment()
            val args = Bundle()
            args.putString(POSTCARD_GROUP_ID, postcardGroupId)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.postcard_view_pager, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = view.findViewById<ViewPager>(R.id.viewpager)
        adapter = ViewPagerAdapter(fragmentManager)
        viewPager.adapter = adapter
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PagerViewModel::class.java)

        var postcardGroupId: String? = null
        if (arguments != null)
            postcardGroupId = arguments!!.getString(POSTCARD_GROUP_ID)

        if (postcardGroupId != null) {
            viewModel.getPostcards(postcardGroupId)?.observe(viewLifecycleOwner, Observer { it ->
                it?.forEach {
                    adapter.addFragment(PostcardFragment.newInstance(it.postcardId), it.title)
                }
                adapter.notifyDataSetChanged()
            })
        }
    }
}