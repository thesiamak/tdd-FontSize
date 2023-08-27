package com.siamak.tdd.fontsize.ui.userProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siamak.tdd.fontsize.data.model.FontRatioUiModel
import com.siamak.tdd.fontsize.data.user.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class UserProfileViewModel(
    userRepository: UserRepository
) : ViewModel() {

    val fontRatio: StateFlow<FontRatioUiModel> = userRepository.fontRatio.stateIn(
        initialValue = FontRatioUiModel(DEFAULT_FONT_RATIO),
        scope = viewModelScope,
        started = SharingStarted.Lazily
    )

    companion object {
        private const val DEFAULT_FONT_RATIO = 1.0f
    }
}

