package com.siamak.tdd.fontsize.data.user

import com.siamak.tdd.fontsize.data.SharedPreferenceHelper
import com.siamak.tdd.fontsize.data.model.FontRatioUiModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val fontRatio: Flow<FontRatioUiModel>
}

class UserRepositoryImpl(
    private val daraSource: SharedPreferenceHelper
) : UserRepository {
    override val fontRatio: Flow<FontRatioUiModel>
        get() = TODO("Not yet implemented")

    private val deviceDensity = 1.0f
    private val standardFontSize = 1.0f

    fun saveFontRatio(fontRatio: Float) {
        daraSource.saveFontRatio(fontRatio)
    }
    fun getFontRatio(): Float {
        return daraSource.fetchFontRatio()
    }
    fun getDefaultFontSize(): Float = calculate(DEFAULT_AGE)

    fun getFontSizeByAge(age: Int): Float = calculate(age)
    fun calculate(age: Int): Float {
        val zoomRatio = age * DEFAULT_FONT_RATIO / deviceDensity
        val fontSize = zoomRatio * standardFontSize
        return fontSize
    }

    companion object {
        private const val DEFAULT_FONT_RATIO = 1.0f
        private const val DEFAULT_AGE = 30
    }
}