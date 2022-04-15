package com.example.currentnews.extension

import android.graphics.Bitmap
import android.util.Base64

import java.io.ByteArrayOutputStream


fun Bitmap.toByteArray(quality: Int): ByteArray {

    ByteArrayOutputStream().apply {
        compress(Bitmap.CompressFormat.JPEG, 10, this)
        return toByteArray()
    }
}

fun Bitmap.toBase64(): String? {
    return Base64.encodeToString(this.toByteArray(100), Base64.DEFAULT)
}
