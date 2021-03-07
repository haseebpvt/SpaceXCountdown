package com.pensource.spacexcountdown.data.source.nextlaunch

import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.data.source.remote.Service
import javax.inject.Inject

interface NextLaunchDataSource {
    fun getNextLaunch(): NextLaunch
}

class DefaultNextLaunchDataSource @Inject constructor(
    private val api: Service
) : NextLaunchDataSource {

    override fun getNextLaunch(): NextLaunch {
        return api.getNextLaunch()
    }
}