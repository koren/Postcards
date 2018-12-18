package com.websungroup.postcards.ui.list

import com.websungroup.postcards.data.Postcard

internal interface Callback {
    fun onLocationSelected(postcard: Postcard)
}
