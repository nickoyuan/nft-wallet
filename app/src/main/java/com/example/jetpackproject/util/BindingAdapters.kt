package com.example.jetpackproject.util

import android.content.res.Resources
import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("error")
fun EditText.setError(error: Int) {
    try {
        setError(context.getString(error))
        requestFocus()
    } catch (e: Resources.NotFoundException) {
        setError(null)
        clearFocus()
    }
}
