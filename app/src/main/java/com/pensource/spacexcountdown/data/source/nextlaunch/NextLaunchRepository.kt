package com.pensource.spacexcountdown.data.source.nextlaunch

import com.pensource.spacexcountdown.data.model.NextLaunch
import javax.inject.Inject

interface NextLaunchRepository {
    fun getNextLaunch(): NextLaunch
}

class DefaultNextLaunchRepository @Inject constructor(
    private val nextLaunchDataSource: NextLaunchDataSource
) : NextLaunchRepository {

    private var nextLaunch: NextLaunch? = null

    override fun getNextLaunch(): NextLaunch {

        if (nextLaunch == null) {
            nextLaunch = nextLaunchDataSource.getNextLaunch()
        }

        return nextLaunch as NextLaunch
    }
}