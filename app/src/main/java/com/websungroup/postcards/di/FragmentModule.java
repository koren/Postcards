package com.websungroup.postcards.di;

import com.websungroup.postcards.ui.list.PostcardListFragment;
import com.websungroup.postcards.ui.main.MainFragment;
import com.websungroup.postcards.ui.postcard.PostcardFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();

    @ContributesAndroidInjector
    abstract PostcardFragment contributePostcardFragment();

    @ContributesAndroidInjector
    abstract PostcardListFragment contributePostcardListFragment();
}
