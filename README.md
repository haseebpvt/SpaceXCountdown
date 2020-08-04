# SpaceXCountdown [ 🚧 Work in progress 👷⛏👷🔧️👷🔧 🚧 ]
SpaceX upcoming launch countdown using SpaceX-API

## Tech-stack
Following a clean architecture design based on [android/architecture-samples](https://github.com/android/architecture-samples). Some reference are taken from [google/iosched].(https://github.com/google/iosched)
* Tech-stack
  * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
  * [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - dependency injection
  * [Retrofit](https://square.github.io/retrofit/) - networking
  * [Jetpack](https://developer.android.com/jetpack)
    * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
    * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
    * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* Architecture
    * Clean Architecture
    * MVVM
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
