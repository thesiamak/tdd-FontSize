package com.siamak.tdd.fontsize.data.user

import android.content.SharedPreferences
import com.siamak.tdd.fontsize.data.SharedPreferenceHelper
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class `Storage is tested for` {

    private val mockSharedPreference: SharedPreferences = mockk()
    val storage = SharedPreferenceHelper(
        mockSharedPreference
    )

    @Test
    fun `Storage stores font ratio in key-value`() {
        // Given
        val fontRatio = 2.0f
        val mockEditor = mockk<SharedPreferences.Editor>(relaxed = true)
        every { mockSharedPreference.edit() } returns mockEditor
        every { mockEditor.putFloat(any(), any()) } returns mockEditor
        every { mockEditor.apply() } just Runs

        // When
        storage.saveFontRatio(fontRatio)

        // Then
        verify(exactly = 1) { mockEditor.apply() }
    }

    @Test
    fun `Storage fetches font ratio in db`() {
        // Given
        val fontRatio = 2.0f
        every { mockSharedPreference.getFloat(any(), any()) } returns fontRatio

        // When
        val result = storage.fetchFontRatio()

        // Then
        Assertions.assertEquals(/* expected = */ fontRatio, /* actual = */ result)
    }

}