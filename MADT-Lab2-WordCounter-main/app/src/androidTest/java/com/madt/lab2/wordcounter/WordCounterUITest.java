package com.madt.lab2.wordcounter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;


import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.Rule;
import org.junit.Test;


import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class WordCounterUITest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void ENTER_TEXT_AND_CALCULATE_METRICS() {
        onView(withId(R.id.etInputText))
                .perform(clearText(), replaceText("Hello"), closeSoftKeyboard());

        onView(withId(R.id.btnCalculate)).perform(click());

        onView(withId(R.id.tvWordsCount))
                .check(matches(withText("Words: 1")));
    }



    @Test
    public void GENERATE_SAMPLE_TEXT() {
        onView(withId(R.id.btnGenerateSample)).perform(click());

        onView(withId(R.id.etInputText))
                .check(matches(not(withText(""))));
    }

    @Test
    public void CLEAR_INPUT_TEXT() {
        onView(withId(R.id.etInputText))
                .perform(replaceText("Test"), closeSoftKeyboard());

        onView(withId(R.id.btnClearInput)).perform(click());

        onView(withId(R.id.etInputText))
                .check(matches(withText("")));



    }
}