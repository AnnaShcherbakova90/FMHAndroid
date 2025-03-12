package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withSpinnerText;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import java.util.Objects;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class AuthPage {
    public int loginTextInput = R.id.login_text_input_edit_text;
    public int passwordTextInput = R.id.password_text_edit_text;
    public int signInButton = R.id.enter_button;

    public int getLoginTextInput() {
        return loginTextInput;
    }
    public int getPasswordTextInput() {
        return passwordTextInput;
    }
    public int getSignInButton() {
        return signInButton;
    }

    @Step("Set login")
    public void setLogin() {
        onView(withId(getLoginTextInput()))
                .perform(replaceText(Constants.LOGIN));
    }
    @Step("Set password")
    public void setPassword() {
        onView(withId(getPasswordTextInput()))
                .perform(replaceText(Constants.PASSWORD));
    }
    @Step("Click 'SignIn' button")
    public void clickSignInButton() {
        onView(withId(getSignInButton()))
                .perform(click());
    }
    @Step("Set wrong login")
    public void setWrongLogin() {
        onView(withId(getLoginTextInput()))
                .perform(replaceText(Constants.WRONG_LOGIN));
    }
    @Step("Set wrong password")
    public void setWrongPassword() {
        onView(withId(getPasswordTextInput()))
                .perform(replaceText(Constants.WRONG_PASSWORD));
    }
    @Step("Check error popup appears")
    public void checkErrorAppears() {
            onView(withId(R.id.all_news_text_view))
                    .check(doesNotExist());
    }
}
