package com.websungroup.postcards

import android.app.Activity
import android.app.Application
import com.websungroup.postcards.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class PostcardApp : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)
//        repository!!.refreshData()
    }

    override fun activityInjector() = dispatchingAndroidInjector

//    fun activityInjector(): DispatchingAndroidInjector<Activity>? {
//        return dispatchingAndroidInjector
//    }
}