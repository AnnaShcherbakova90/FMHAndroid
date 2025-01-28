package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.espresso.ViewInteraction;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class AuthPage {
    public static int getLoginInputText() {
        return R.id.login_text_input_edit_text;
    }

    public static int getPasswordInputText() {
        return R.id.password_text_edit_text;
    }

    public static int getSignInButton() {
        return R.id.enter_button;
    }

    @Step("Set login")
    public static void setLogin() {
        ViewInteraction loginTextInput = onView(withId(AuthPage.getLoginInputText()));
        loginTextInput.check(matches(isDisplayed()));
        loginTextInput.perform(replaceText(Constants.login), closeSoftKeyboard());
    }

    @Step("Set password")
    public static void setPassword() {
        ViewInteraction loginPasswordInput = onView(withId(AuthPage.getPasswordInputText()));
        loginPasswordInput.check(matches(isDisplayed()));
        loginPasswordInput.perform(replaceText(Constants.password), closeSoftKeyboard());
    }

    @Step("Click 'SignIn' button")
    public static void clickSignInButton() {
        onView(withId(getSignInButton()))
                .perform(click())
                .check(matches(isDisplayed()));
    }
}
