package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.RootMatchers.isPlatformPopup;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
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
public class Scenario_Number_3 {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    // Пользователь авторизован в системе.
    public void Creation_of_news_in_English() {
        onView(isRoot()).perform(waitDisplayed(R.id.main_menu_image_button,5000));
        onView(withId(R.id.main_menu_image_button)).perform(click());
        onView(withText("News")).perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.news_list_swipe_refresh,5000));
        onView(withId(R.id.edit_news_material_button)).perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.action_bar_root,5000));
        onView(withId(R.id.add_news_image_view)).perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.nav_host_fragment,5000));
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_category_text_input_layout,5000));
        onView(withId(R.id.news_item_category_text_input_layout)).perform(click());
        onView(withText("Объявление")).inRoot(isPlatformPopup()).perform(click());
        onView(isRoot()).perform(waitDisplayed(R.id.news_item_title_text_input_layout, 5000));
        onView(allOf(withId(R.id.news_item_title_text_input_edit_text), isDescendantOfA(withId(R.id.news_item_title_text_input_layout))))
                .perform(replaceText(""));
        onView(withId(R.id.news_item_title_text_input_edit_text)).
                perform(click(), typeText("New News"));

        onView(isRoot()).perform(waitDisplayed(R.id.news_item_create_date_text_input_layout, 5000));
        onView(withId(R.id.news_item_create_date_text_input_layout)).perform(click());
        //onView(isRoot()).perform(waitDisplayed(R.id., 5000));
        //onView(withText("1")).perform(click());


    }
}
