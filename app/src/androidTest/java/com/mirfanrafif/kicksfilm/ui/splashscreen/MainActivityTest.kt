package com.mirfanrafif.kicksfilm.ui.splashscreen

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.mirfanrafif.kicksfilm.data.FilmData
import kotlinx.coroutines.delay
import org.junit.Assert.*
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.mirfanrafif.kicksfilm.R
import org.junit.Rule
import org.junit.Test

class MainActivityTest {
    private val dummyMovies = FilmData.getMovies()
    private val dummyTvShows = FilmData.getTVShows()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        Thread.sleep(2000)
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailMovie() {
        Thread.sleep(2000)
        val movie = dummyMovies[0]
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_category)).check(matches(isDisplayed()))
        onView(withId(R.id.text_category)).check(matches(withText(movie.category)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(movie.overview)))
        onView(withId(R.id.text_tahun)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tahun)).check(matches(withText(movie.year.toString())))
    }

    @Test
    fun loadTvShows() {
        Thread.sleep(2000)
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
    }

    @Test
    fun loadDetailTvShow() {
        val movie = dummyTvShows[0]
        Thread.sleep(2000)
        onView(withId(R.id.tabs)).check(matches(isDisplayed()))
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.text_category)).check(matches(isDisplayed()))
        onView(withId(R.id.text_category)).check(matches(withText(movie.category)))
        onView(withId(R.id.text_description)).check(matches(isDisplayed()))
        onView(withId(R.id.text_description)).check(matches(withText(movie.overview)))
        onView(withId(R.id.text_tahun)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tahun)).check(matches(withText(movie.year.toString())))
    }
}