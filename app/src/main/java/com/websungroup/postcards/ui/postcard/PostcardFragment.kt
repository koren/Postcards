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
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class PostcardFragment : Fragment() {

    @Inject
    var viewModelFactory: ViewModelProvider.Factory? = null

    private lateinit var binding: ViewDataBinding

    companion object {
        private const val POSTCARD_ID = "POSTCARD_ID"
        fun getInstance(postcardId: String): Fragment {
            val fragment = Fragment()

            val args = Bundle()
            args.putString(POSTCARD_ID, postcardId)
            fragment.arguments = args

            return fragment
        }
    }

    private var postcard: Postcard? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        prepareData()
//
//        val toolbar = findViewById<Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)
//        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
//        getSupportActionBar()!!.setDisplayShowHomeEnabled(true)
//        getSupportActionBar()!!.setTitle(type.presentation)
//
//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(SmartboxDetailsViewModel::class.java!!)
//        viewModel.setLocationData(locationId, type)
//
//        binding.setViewModel(viewModel)
//        binding.setClickListener({ v ->
//            val location = viewModel.getLocation()
//            if (location != null && location!!.getLongitude() != null && location!!.getLatitude() != null)
//                openMap(location!!)
//            //todo impl error message when incorrect location
//        })
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
//
//        var postcardId: String? = null
//        if (arguments != null)
//            postcardId = arguments!!.getString(POSTCARD_ID)
//
//        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostcardViewModel::class.java!!)
//        viewModel.setPostcardId(postcardId)
//        binding.setViewModel(viewModel)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.postcard, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var postcardId: String? = null
        if (arguments != null)
            postcardId = arguments!!.getString(POSTCARD_ID)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostcardViewModel::class.java!!)
        viewModel.setPostcard(postcardId)

//        binding.(viewModel)
        binding.setLifecycleOwner(viewLifecycleOwner)
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
