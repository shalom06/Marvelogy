package com.shalom.marvelogy

import androidx.fragment.app.testing.launchFragmentInContainer
import com.shalom.marvelogy.ui.marvelmainfragment.fragments.MarvelMainFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainFragmentTest {

    @get:Rule
    var rule = HiltAndroidRule(this)

    @Before
    fun init() {
        rule.inject()
    }

    @Test
    fun test() {
    }
}