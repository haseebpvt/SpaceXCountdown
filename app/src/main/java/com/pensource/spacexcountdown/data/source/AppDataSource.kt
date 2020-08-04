package com.pensource.spacexcountdown.data.source

import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch

interface AppDataSource {

    suspend fun getNextLaunch(): Result<NextLaunch>
}