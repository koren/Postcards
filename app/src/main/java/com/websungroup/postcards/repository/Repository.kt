package com.websungroup.postcards.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.websungroup.postcards.api.PostcardService
import com.websungroup.postcards.data.Postcard
import com.websungroup.postcards.data.Resource
import java.util.concurrent.Executor
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(
    private val postcardService: PostcardService,
    private val executor: Executor
) {
    val postcards = mutableListOf<Postcard>()

    fun refreshData() {
        Log.d("TAG", "refreshData: ")
        createDemoData()
        //        executor.execute(() ->
        //                postcardService.downloadFileWithFixedUrl().enqueue(new Callback<List<Location>>() {
        //
        //                    @Override
        //                    public void onResponse(@NonNull Call<List<Location>> call, @NonNull Response<List<Location>> response) {
        //                        if (response.isSuccessful() && response.body() != null) {
        //                            for (Location item : response.body()) {
        //
        //                                if (item.getType() == null)
        //                                    continue;
        //
        //                                if (item.getType().equals(ELocationType.Event.toString())) {
        //                                    events.add(item);
        //                                } else if (item.getType().equals(ELocationType.Shop.toString())) {
        //                                    shops.add(item);
        //                                }
        //                            }
        //                        }  //todo implement alert in else
        //                    }
        //
        //                    @Override
        //                    public void onFailure(@NonNull Call<List<Location>> call, @NonNull Throwable t) {
        //                        //todo implement alert
        //                        refreshData();
        //                    }
        //                })
        //        );
    }

    fun createDemoData() {
        var urls = arrayOf(
            "https://moiotkrytki.ru/gifs/12053.gif",
            "https://moiotkrytki.ru/gifs/12067.gif",
            "https://moiotkrytki.ru/gifs/12051.gif",
            "https://moiotkrytki.ru/gifs/12051.gif",
            "https://moiotkrytki.ru/gifs/12059.gif",
            "https://moiotkrytki.ru/gifs/12048.gif",
            "https://moiotkrytki.ru/gifs/12057.gif",
            "https://moiotkrytki.ru/gifs/12044.gif",
            "https://moiotkrytki.ru/gifs/12056.gif",
            "https://moiotkrytki.ru/gifs/12050.gif",
            "https://moiotkrytki.ru/gifs/12045.gif"
        )

        for ((index, value) in urls.withIndex()) {
            val postcard = Postcard()
            postcard.postcardId = index.toString()
            postcard.title = "title $index"
            postcard.description = "description $index"
            postcard.imageUrl = value
            postcards.add(postcard)
        }
    }

    fun getPostcard(postcardId: String?): Postcard? {
        if (postcardId != null)
            postcards.forEach {
                if (it.postcardId == postcardId)
                    return it
            }

        return null
    }

    fun loadPostcards(postcardGroupId: String?): LiveData<List<Postcard>> {
        val postcardsLiveData = MutableLiveData<List<Postcard>>()
        postcardsLiveData.value = postcards
        return postcardsLiveData
    }

    //    public Location getLocation(int locationId, ELocationType type) {
    //        List<Location> locations = null;
    //        switch (type) {
    //            case Event:
    //                locations = events;
    //                break;
    //            case Shop:
    //                locations = shops;
    //                break;
    //        }
    //        if (locations != null)
    //            for (Location location : locations)
    //                if (location.getPostcardId().equals(locationId))
    //                    return location;
    //        return null;
    //    }

    //    public ObservableArrayList<Postcard> getLocations(ELocationType type) {
    //        switch (type) {
    //            case Event:
    //                return events;
    //            case Shop:
    //                return shops;
    //        }
    //        return null;
}
