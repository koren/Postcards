package com.websungroup.postcards.di;

import com.websungroup.postcards.ui.list.PostcardListActivity;
import com.websungroup.postcards.ui.main.MainActivity;
import com.websungroup.postcards.ui.postcard.PostcardActivity;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityModule {
    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract PostcardListActivity contributePostcardListActivity();

    @ContributesAndroidInjector(modules = FragmentModule.class)
    abstract PostcardActivity contributePostcardActivity();
}
