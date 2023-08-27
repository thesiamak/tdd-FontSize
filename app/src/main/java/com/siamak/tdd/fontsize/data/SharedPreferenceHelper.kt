package com.siamak.tdd.fontsize.data

import android.content.SharedPreferences

class SharedPreferenceHelper(
    private val sharedPreferences: SharedPreferences
) {

    fun saveFontRatio(fontRatio: Float) {
        sharedPreferences.edit().putFloat("font-ratio", fontRatio).apply()
    }

    fun fetchFontRatio(): Float {
        return sharedPreferences.getFloat("font-ratio", 1.0f)
    }
}