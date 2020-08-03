package com.shalom.marvelogy

import com.shalom.marvelogy.repos.marvelrepository.MarvelRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class MainApiTest {
    @get:Rule
    var rule = HiltAndroidRule(this)

    @Inject
    lateinit var marvelRepository: MarvelRepository

    @Before
    fun init() {
        rule.inject()
    }

    @Test
    fun test() = runBlocking {
        var successFull = false
        marvelRepository.getCharacters().collect {
            if (it.data?.charactersApiResponse?.code == "200") successFull = true
        }
        assert(successFull)
    }

    @After
    fun remove(){

    }
}