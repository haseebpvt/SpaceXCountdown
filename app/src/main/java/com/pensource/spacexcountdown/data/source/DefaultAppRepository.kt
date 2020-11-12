package com.pensource.spacexcountdown.data.source

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.util.Preference
import javax.inject.Inject

class DefaultAppRepository @Inject constructor(
    private val localAppDataSource: AppDataSource,
    private val remoteAppDataSource: AppDataSource
) : AppRepository {

    override suspend fun getNextLaunch(): Result<NextLaunch> {
        return remoteAppDataSource.getNextLaunch()
    }

    override suspend fun getRemainingTimeForNextLaunch(): Long {
        TODO("Not yet implemented")
    }
}