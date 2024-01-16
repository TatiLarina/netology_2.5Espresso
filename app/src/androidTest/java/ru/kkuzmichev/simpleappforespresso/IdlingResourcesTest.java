package ru.kkuzmichev.simpleappforespresso;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class IdlingResourcesTest {

    private ViewInteraction appCompatImageButton = onView(withContentDescription("Open navigation drawer"));
    private ViewInteraction checkedTextGallery = onView(withId(R.id.nav_gallery));
    private ViewInteraction item7 = onView(allOf(withId(R.id.item_number), withText("7")));
    private ViewInteraction recycleListing = onView(withId(R.id.recycle_view));

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void registerIdlingResources() {
        IdlingRegistry.getInstance().register(EspressoIdlingResources.idlingResource);
    }

    @After
    public void unregisterIdlingResources() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResources.idlingResource);
    }

    @Test
    public void idlingResourcesTest() {
        appCompatImageButton.check(matches(isDisplayed()));
        appCompatImageButton.perform(click());
        checkedTextGallery.check(matches(isDisplayed()));
        checkedTextGallery.perform(click());
        item7.check(matches(isDisplayed()));
        item7.check(matches(withText("7")));
    }


}