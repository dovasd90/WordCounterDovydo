package com.example.wordcounterdovydo;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WordCounterTests {

    @Rule
    public ActivityScenarioRule<MainActivity> activityScenarioRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testEmptyInput() {
        onView(withId(R.id.edUserInput)).perform(replaceText(""), closeSoftKeyboard());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResults)).check(matches(withText("Words: 0, Characters: 0")));
    }

    @Test
    public void testNormalText() {
        onView(withId(R.id.edUserInput)).perform(replaceText("Hello world"), closeSoftKeyboard());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResults)).check(matches(withText("Words: 2, Characters: 11")));
    }

    @Test
    public void testSpacesOnly() {
        onView(withId(R.id.edUserInput)).perform(replaceText("     "), closeSoftKeyboard());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResults)).check(matches(withText("Words: 0, Characters: 5")));
    }

    @Test
    public void testPunctuationOnly() {
        onView(withId(R.id.edUserInput)).perform(replaceText("!!!???"), closeSoftKeyboard());
        onView(withId(R.id.btnCount)).perform(click());
        onView(withId(R.id.tvResults)).check(matches(withText("Words: 0, Characters: 6")));
    }
}
