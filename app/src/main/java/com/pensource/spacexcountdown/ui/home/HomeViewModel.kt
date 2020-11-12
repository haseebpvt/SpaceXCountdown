package com.pensource.spacexcountdown.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pensource.spacexcountdown.data.Result
import com.pensource.spacexcountdown.data.model.NextLaunch
import com.pensource.spacexcountdown.data.source.AppRepository
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {

    private val _nextLaunch = MutableLiveData<NextLaunch>().apply {
//        viewModelScope.launch {
//            when(val result =  repository.getNextLaunch()) {
//                is Result.Success -> {
//                    value = result.data
//
//                    // Mission name
//                    _nextLaunchTitle.value = result.data.missionName
//
//                    // Remaining time for launch
//                    _nextLaunchCountdown.value = getRemainingTimeForLaunch(
//                        result.data.launchDateUnix * 1000,
//                        Date().time
//                    )
//                }
//            }
//        }
    }
    val nextLaunch: LiveData<NextLaunch> = _nextLaunch

    private val _nextLaunchTitle = MutableLiveData<String>()
    val nextLaunchTitle: LiveData<String> = _nextLaunchTitle

    private val _nextLaunchCountdown = MutableLiveData<Long>()
    val nextLaunchCountdown: LiveData<Long> = _nextLaunchCountdown

    private fun getRemainingTimeForLaunch(launchTime: Long, currentTime: Long): Long {
        return launchTime - currentTime
    }
}