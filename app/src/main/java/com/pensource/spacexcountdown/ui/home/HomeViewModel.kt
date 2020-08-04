package com.pensource.spacexcountdown.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.data.source.AppRepository
import com.pensource.spacexcountdown.util.API_DATE_FORMAT
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _nextLaunch = MutableLiveData<NextLaunch>().apply {
        viewModelScope.launch {
            when(val result =  repository.getNextLaunch()) {
                is Result.Success -> {
                    value = result.data

                    // Mission name
                    _nextLaunchTitle.value = result.data.missionName

                    // Remaining time for launch
                    _nextLaunchCountdown.value = getRemainingTimeForLaunch(
                        result.data.lastDateUpdate,
                        Date().time
                    )
                }
            }
        }
    }
    val nextLaunch: LiveData<NextLaunch> = _nextLaunch

    private val _nextLaunchTitle = MutableLiveData<String>()
    val nextLaunchTitle: LiveData<String> = _nextLaunchTitle

    private val _nextLaunchCountdown = MutableLiveData<Long>()
    val nextLaunchCountdown: LiveData<Long> = _nextLaunchCountdown

    private fun getRemainingTimeForLaunch(launchDate: String, currentTime: Long): Long? {
        val launchTimeInMills = parseDate(launchDate, API_DATE_FORMAT)?.time
//        return launchTimeInMills?.minus(currentTime)
        return currentTime.minus(launchTimeInMills!!)
    }

    private fun parseDate(date: String, format: String): Date? {
        return SimpleDateFormat(format, Locale.getDefault()).parse(date)
    }
}