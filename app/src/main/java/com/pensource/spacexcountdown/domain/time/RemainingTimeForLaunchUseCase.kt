package com.pensource.spacexcountdown.domain.time

import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.source.nextlaunch.NextLaunchRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import org.joda.time.DateTime
import javax.inject.Inject

class RemainingTimeForLaunchUseCase @Inject constructor(
    private val repository: NextLaunchRepository,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(currentTime: DateTime): Result<Long> = withContext(dispatcher) {
        val result = try {
            val launchDate = repository.getNextLaunch().launchDateUtc
            val dateTime = DateTime.parse(launchDate)

            dateTime.millis - currentTime.millis
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }

        return@withContext Result.Success(result)
    }
}