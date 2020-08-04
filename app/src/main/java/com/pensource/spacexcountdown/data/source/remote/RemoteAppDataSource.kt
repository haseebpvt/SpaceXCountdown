package com.pensource.spacexcountdown.data.source.remote

import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.data.source.AppDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

class RemoteAppDataSource constructor(
    private val service: Service,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : AppDataSource {

    override suspend fun getNextLaunch(): Result<NextLaunch> = withContext(dispatcher) {
        val result = try {
            service.getNextLaunch()
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }

        return@withContext Result.Success(result)
    }
}