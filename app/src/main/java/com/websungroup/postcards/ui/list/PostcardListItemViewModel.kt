package com.websungroup.postcards.ui.list

import android.arch.lifecycle.ViewModel
import com.websungroup.postcards.data.Postcard
import javax.inject.Inject

class PostcardListItemViewModel @Inject constructor(val postcard: Postcard) : ViewModel()