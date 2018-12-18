package com.websungroup.postcards.ui.list;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.recyclerview.extensions.AsyncListDiffer;
import android.support.v7.util.AdapterListUpdateCallback;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.websungroup.postcards.R;
import com.websungroup.postcards.data.Postcard;

import java.util.List;


public class PostcardListAdapter extends RecyclerView.Adapter<PostcardListItemHolder> {
    private AsyncListDiffer<Postcard> helper;
    Callback callback;

    PostcardListAdapter(PostcardListItemDiffCallback diffCallback) {
        helper = new AsyncListDiffer<>(new AdapterListUpdateCallback(this), new AsyncDifferConfig.Builder<>(diffCallback).build());
    }

    @NonNull
    @Override
    public PostcardListItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        return new PostcardListItemHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(parent.getContext()),
                        R.layout.list_item, parent, false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PostcardListItemHolder holder, int position) {
        Postcard item = helper.getCurrentList().get(position);
        holder.bind(item, callback);
    }

    @Override
    public int getItemCount() {
        return helper.getCurrentList().size();
    }

    public void submitList(List<Postcard> items) {
        helper.submitList(items);
    }
}
