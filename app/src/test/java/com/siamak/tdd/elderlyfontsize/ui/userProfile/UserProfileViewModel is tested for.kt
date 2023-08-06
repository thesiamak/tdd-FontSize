@file:OptIn(ExperimentalTime::class, ExperimentalTime::class)

package com.siamak.tdd.elderlyfontsize.ui.userProfile

import app.cash.turbine.test
import com.siamak.tdd.elderlyfontsize.data.model.FontRatioUiModel
import com.siamak.tdd.elderlyfontsize.data.user.UserRepository
import io.mockk.every
import io.mockk.mockk
import kotlin.time.ExperimentalTime
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class `UserProfileViewModel is tested for` {

    init {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }
    val mockUserRepository = mockk<UserRepository>()

    @Test
    fun `Font Ratio is fetched from data source`() = runTest {
        // Given
        val expectedRatio = 2.0f
        every { mockUserRepository.fontRatio } returns flowOf(FontRatioUiModel(expectedRatio))
        val viewModel = UserProfileViewModel(userRepository = mockUserRepository)

        // When
        viewModel.fontRatio.test {
            val fromDataSource = expectItem()

            // Then
            assertEquals(/* expected = */ expectedRatio, /* actual = */ fromDataSource.fontRatio)
        }
    }

    @Test
    fun `user update is called so age calculations are triggered`() {
        // Given

        // When

        // Then
    }

    @Test
    fun `Font Ratio is updated with new emissions from data source`() {
        // Given

        // When

        // Then

    }


}