package com.siamak.tdd.elderlyfontsize.data.user

import com.siamak.tdd.elderlyfontsize.data.model.FontRatioUiModel
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    val fontRatio: Flow<FontRatioUiModel>
}

//class UserRepositoryImpl() : UserRepository {

//}