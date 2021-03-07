package com.pensource.spacexcountdown.data.source.remote

import com.pensource.spacexcountdown.data.model.NextLaunch
import retrofit2.http.GET

interface Service {

    @GET("launches/next")
    fun getNextLaunch(): NextLaunch
}