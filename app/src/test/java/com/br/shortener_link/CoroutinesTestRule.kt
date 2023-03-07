package com.br.shortener_link

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description


class CoroutinesTestRule(
    private val dispatcher: TestDispatcher = StandardTestDispatcher()
) : TestWatcher() {

    val scope = TestScope(dispatcher)

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }


    fun runBlockingTest(block: suspend TestScope.() -> Unit) {
        scope.runTest { this.block() }
    }
}
