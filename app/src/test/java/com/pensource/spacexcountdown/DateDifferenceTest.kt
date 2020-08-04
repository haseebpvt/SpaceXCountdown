package com.pensource.spacexcountdown

import org.junit.Test

import org.junit.Assert.*
import java.text.SimpleDateFormat
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DateDifferenceTest {
    @Test
    fun hourDifferenceTest() {
        val date1 = SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse("01:00:00 01-01-2000")
        val date2 = SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse("02:00:00 01-01-2000")

        val diff = date2.time - date1.time
        val expectedDiff: Long = 1000 * 60 * 60

        assertEquals(expectedDiff, diff)
    }

    @Test
    fun dayDifferenceTest() {
        val date1 = SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse("01:00:00 01-01-2000")
        val date2 = SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse("01:00:00 02-01-2000")

        val diff = date2.time - date1.time
        val expectedDiff: Long = 1000 * 60 * 60 * 24

        assertEquals(expectedDiff, diff)
    }
}