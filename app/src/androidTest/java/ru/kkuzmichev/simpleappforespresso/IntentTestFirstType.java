package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.content.Intent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;
import org.junit.Test;


public class IntentTestFirstType {
    @Rule
    public IntentsTestRule intentsTestRule = new IntentsTestRule(MainActivity.class);

    @Test
    public void testIntent() {
        ViewInteraction overflowMenuButton = onView(withContentDescription("More options"));
        overflowMenuButton.check(matches(isDisplayed()));
        overflowMenuButton.perform(click());
        ViewInteraction materialTextView = onView(withText("Settings"));
        materialTextView.check(matches(isDisplayed()));
        materialTextView.perform(click());
        intended(hasData("https://google.com"));
        intended(hasAction(Intent.ACTION_VIEW));
    }

}