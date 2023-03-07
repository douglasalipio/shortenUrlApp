package com.br.shortener_link.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import org.junit.Assert
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

fun <T> LiveData<T>.getOrAwaitValue(
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object : Observer<T> {
        override fun onChanged(observedData: T?) {
            data = observedData
            latch.countDown()
            this@getOrAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }
    } finally {
        this.removeObserver(observer)
    }

    @Suppress("UNCHECKED_CAST")
    return data as T
}

fun <T> LiveData<T>.assertNotEmitted(
    time: Long = 10,
    timeUnit: TimeUnit = TimeUnit.MILLISECONDS
) {
    try {
        getOrAwaitValue(time, timeUnit)
        Assert.assertTrue(false)
    } catch (exception: TimeoutException) {
        Assert.assertTrue(true)
    }
}

fun <T> LiveData<T>.assertEmittedExactly(
    assertEmittedTimes: Int,
    time: Long = 10,
    timeUnit: TimeUnit = TimeUnit.MILLISECONDS
) {
    try {
        countDownAwaitValue(assertEmittedTimes, time, timeUnit)
        Assert.assertTrue(true)
    } catch (ex: TimeoutException) {
        Assert.assertTrue(false)
    }
}

fun <T> LiveData<T>.countDownAwaitValue(
    countDownTimes: Int,
    time: Long = 2,
    timeUnit: TimeUnit = TimeUnit.SECONDS,
    afterObserve: () -> Unit = {}
) {
    val latch = CountDownLatch(countDownTimes)
    val observer = object : Observer<T> {
        override fun onChanged(observedData: T?) {
            latch.countDown()
            this@countDownAwaitValue.removeObserver(this)
        }
    }
    this.observeForever(observer)

    try {
        afterObserve.invoke()

        // Don't wait indefinitely if the LiveData is not set.
        if (!latch.await(time, timeUnit)) {
            throw TimeoutException("LiveData value was never set.")
        }
    } finally {
        this.removeObserver(observer)
    }
}

fun <T> LiveData<T>.assertEmitted(
    time: Long = 10,
    timeUnit: TimeUnit = TimeUnit.MILLISECONDS
) {
    try {
        getOrAwaitValue(time, timeUnit)
        Assert.assertTrue(true)
    } catch (exception: TimeoutException) {
        Assert.assertTrue(false)
    }
}
