package com.websungroup.postcards.ui.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.websungroup.postcards.R
import com.websungroup.postcards.repository.Repository
import com.websungroup.postcards.ui.list.PostcardListFragment
import com.websungroup.postcards.ui.postcard.PostcardFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var repository: Repository

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return dispatchingAndroidInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        (supportActionBar as ActionBar).setTitle(R.string.postcards)


        repository.refreshData()

        //todo test list
        /*getSupportFragmentManager().beginTransaction()
            .add(R.id.fragmentContainer, PostcardListFragment())
            .addToBackStack(null)
            .commit()*/
        //todo test item
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, PostcardFragment.getInstance("0"))
            .addToBackStack(null)
            .commit()

        //        val tabs = findViewById<TabLayout>(R.id.tabs)
//        val viewPager = findViewById<ViewPager>(R.id.viewpager)
//        val adapter = ViewPagerAdapter(supportFragmentManager)
//        adapter.addFragment(SmartboxListFragment.newInstance(ELocationType.Event), ELocationType.Event.presentation)
//        adapter.addFragment(SmartboxListFragment.newInstance(ELocationType.Shop), ELocationType.Shop.presentation)
//        viewPager.adapter = adapter

//        tabs.setupWithViewPager(viewPager)

    }
}
