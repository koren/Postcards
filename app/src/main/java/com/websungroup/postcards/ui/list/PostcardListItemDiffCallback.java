package com.websungroup.postcards.ui.list;

import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import com.websungroup.postcards.data.Postcard;

public class PostcardListItemDiffCallback extends DiffUtil.ItemCallback<Postcard> {
    @Override
    public boolean areItemsTheSame(@NonNull Postcard oldItem, @NonNull Postcard newItem) {
        return oldItem.getPostcardId().equals(newItem.getPostcardId());
    }

    @Override
    public boolean areContentsTheSame(@NonNull Postcard oldItem, @NonNull Postcard newItem) {
        return oldItem == newItem;
    }
}
