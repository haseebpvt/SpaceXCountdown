package com.pensource.spacexcountdown.data.source.nextlaunch

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import junit.framework.TestCase

class DefaultNextLaunchRepositoryTest : TestCase() {

    private lateinit var repository: DefaultNextLaunchRepository

    override fun setUp() {
        super.setUp()
        repository = DefaultNextLaunchRepository(mock<DefaultNextLaunchDataSource> {
            on { getNextLaunch() } doReturn mock()
        })
    }

    fun `test check singleton`() {
        val firstInstance = repository.getNextLaunch()
        val secondInstance = repository.getNextLaunch()

        assertTrue(firstInstance === secondInstance)
    }
}