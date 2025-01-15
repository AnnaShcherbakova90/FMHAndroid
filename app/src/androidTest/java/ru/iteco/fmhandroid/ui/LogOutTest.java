package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.TestUtils.waitDisplayed;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class LogOutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void logOutTest() {

        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 6000));

        ViewInteraction authIcon = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
                        isDisplayed()));
        authIcon.perform(click());

        ViewInteraction logOutTitle = onView(
                allOf(withId(android.R.id.title), withText("Log out"),
                        isDisplayed()));
        logOutTitle.perform(click());

        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 6000));

        ViewInteraction loginTextInput = onView(
                allOf(withId(R.id.login_text_input_edit_text)));
        loginTextInput.check(matches(isDisplayed()));

    }
}
