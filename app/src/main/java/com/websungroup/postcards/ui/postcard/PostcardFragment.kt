package com.websungroup.postcards.ui.postcard

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.websungroup.postcards.R
import com.websungroup.postcards.data.Postcard
import com.websungroup.postcards.databinding.PostcardBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PostcardFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: PostcardBinding
    private var postcard: Postcard? = null

    companion object {
        private const val POSTCARD_ID = "POSTCARD_ID"
        fun newInstance(postcardId: String): Fragment {
            val fragment = PostcardFragment()

            val args = Bundle()
            args.putString(POSTCARD_ID, postcardId)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        var postcardId: String? = null
        if (arguments != null)
            postcardId = arguments!!.getString(POSTCARD_ID)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostcardViewModel::class.java)
        viewModel.setPostcard(postcardId)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(viewLifecycleOwner)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<ViewDataBinding>(
            inflater,
            R.layout.postcard,
            container,
            false
        ) as PostcardBinding
        return binding.root
    }
}

//    override fun onSupportNavigateUp(): Boolean {
//        onBackPressed()
//        return true
//    }

//    private fun openMap(location: Location) {
//        val intent = MapActivity.newIntent(this, location.getLatitude(), location.getLongitude())
//        startActivity(intent)
//    }

//    private fun prepareData() {
//        if (getIntent() != null) {
//            locationId = getIntent().getIntExtra(LOCATION_ID, -1)
//            type = ELocationType.values()[getIntent().getIntExtra(TYPE, -1)]
//        }
//    }
