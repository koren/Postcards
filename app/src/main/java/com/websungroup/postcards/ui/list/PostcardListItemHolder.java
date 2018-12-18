package com.websungroup.postcards.ui.list;

import android.support.v7.widget.RecyclerView;
import com.websungroup.postcards.data.Postcard;
import com.websungroup.postcards.databinding.ListItemBinding;

class PostcardListItemHolder extends RecyclerView.ViewHolder {

    private final ListItemBinding binding;

    PostcardListItemHolder(ListItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    void bind(final Postcard postcard, Callback callback) {
        binding.setViewModel(new PostcardListItemViewModel(postcard));
        binding.setClickListener(v -> callback.onLocationSelected(postcard));
        binding.executePendingBindings();
    }
}
