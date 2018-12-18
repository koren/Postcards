package com.websungroup.postcards.databinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.websungroup.postcards.data.Postcard;
import com.websungroup.postcards.ui.list.PostcardListAdapter;

import java.util.List;

public class CommonBindingUtils {

    @BindingAdapter("app:imageUrl")
    public static void bind(ImageView view, String imageUrl) {
        Glide.with(view.getContext())
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(view);
    }

    @BindingAdapter({"app:adapter", "app:data"})
    public static void bind(RecyclerView view, PostcardListAdapter adapter, List<Postcard> data) {
        view.setAdapter(adapter);
        adapter.submitList(data);
    }
}
