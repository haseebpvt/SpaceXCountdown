package com.pensource.spacexcountdown.domain.time

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.data.source.nextlaunch.DefaultNextLaunchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.tz.UTCProvider
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class RemainingTimeForLaunchUseCaseTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    @ExperimentalCoroutinesApi
    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        DateTimeZone.setProvider(UTCProvider())
    }

    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun `simple test`() = runBlocking {
        // Given
        val launchDate = "2000-01-01T01:00:00.000Z"
        val currentTime = DateTime(2000, 1, 1, 0, 0)
        val oneHour: Long = 1000 * 60 * 60

        val nextLaunch = mock<NextLaunch> {
            on { launchDateUtc } doReturn launchDate
        }

        val repository = mock<DefaultNextLaunchRepository>() {
            on { getNextLaunch() } doReturn nextLaunch
        }

        val remainingTimeForLaunchUseCase = RemainingTimeForLaunchUseCase(
            repository = repository,
            dispatcher = testDispatcher
        )

        // When
        val result = remainingTimeForLaunchUseCase(currentTime)
        val remainingTime = (result as Result.Success).data

        // Then
        assertEquals(oneHour, remainingTime)
    }
}