package com.pensource.spacexcountdown.data.source

import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch

interface AppRepository {

    suspend fun getNextLaunch(): Result<NextLaunch>

    suspend fun getRemainingTimeForNextLaunch(): Long
}