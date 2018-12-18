package com.websungroup.postcards.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.websungroup.postcards.api.PostcardService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import javax.inject.Singleton;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Module(includes = ViewModelModule.class)
public class AppModule {

    private static String BASE_URL = "http://moiotkrytki.ru/";

    @Provides
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    Executor provideExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    @Provides
    Retrofit provideRetrofit(Gson gson) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    PostcardService provideApiSmartboxService(Retrofit restAdapter) {
        return restAdapter.create(PostcardService.class);
    }
}
