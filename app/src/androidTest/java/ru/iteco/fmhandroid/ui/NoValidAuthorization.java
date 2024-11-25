package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.customFile.TestUtilities.waitDisplayed;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class NoValidAuthorization {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void shouldBeAbleToLoadList() {
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 15000));
        onView(withId(R.id.login_text_input_layout)).perform(click());
        onView(withId(R.id.login_edit_text)).perform(click(), typeText("login2"));
        onView(withId(R.id.password_text_input_layout)).perform(click());
        onView(withId(R.id.password_edit_text)).perform(click(), typeText("password2"));
        onView(withId(R.id.enter_button)).perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.container_list_news_include_on_fragment_main, 15000));
        onView(withText("News")).check(matches(isDisplayed()));
    }
}
