package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
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
public class LogInOutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void logInOutTest() {

        //log in check
        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 6000)); //waiting for App is up and running and 'login' and 'password' text inputs are displayed

        ViewInteraction loginTextInput = onView(
                allOf(withId(R.id.login_text_input_edit_text)));
        loginTextInput.check(matches(isDisplayed()));
        loginTextInput.perform(replaceText("login2"), closeSoftKeyboard());


        ViewInteraction passwordTextInput = onView(
                allOf(withId(R.id.password_text_edit_text)));
        passwordTextInput.check(matches(isDisplayed()));
        passwordTextInput.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction logInButton = onView(
                allOf(withId(R.id.enter_button)));
        logInButton.check(matches(isDisplayed()));
        logInButton.perform(click());

        onView(isRoot()).perform(waitDisplayed(R.id.all_news_text_view, 6000));

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.authorization_image_button)));
        imageButton.check(matches(isDisplayed()));

        //log out check
        imageButton.perform(click());

        ViewInteraction logOutTitle = onView(
                allOf(withId(android.R.id.title), withText("Log out"),
                        isDisplayed()));
        logOutTitle.perform(click());

        onView(isRoot()).perform(waitDisplayed(R.id.login_text_input_layout, 6000));

        onView(
                allOf(withId(R.id.login_text_input_edit_text)));
        loginTextInput.check(matches(isDisplayed()));
    }
}
