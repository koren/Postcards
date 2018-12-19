package com.websungroup.postcards.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import com.websungroup.postcards.ui.list.PostcardListViewModel;
import com.websungroup.postcards.ui.pagerview.PagerViewModel;
import com.websungroup.postcards.ui.postcard.PostcardViewModel;
import com.websungroup.postcards.viewmodel.FactoryViewModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(PostcardListViewModel.class)
    abstract ViewModel bindPostcardListViewModel(PostcardListViewModel listViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PostcardViewModel.class)
    abstract ViewModel bindPostcardViewModel(PostcardViewModel postcardViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(PagerViewModel.class)
    abstract ViewModel bindPagerViewModel(PagerViewModel pagerViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(FactoryViewModel factory);
}
