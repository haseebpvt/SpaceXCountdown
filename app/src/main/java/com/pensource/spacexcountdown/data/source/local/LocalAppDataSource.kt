package com.pensource.spacexcountdown.data.source.local

import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.data.source.AppDataSource

class LocalAppDataSource : AppDataSource {
    override suspend fun getNextLaunch(): Result<NextLaunch> {
        TODO("Not yet implemented")
    }
}