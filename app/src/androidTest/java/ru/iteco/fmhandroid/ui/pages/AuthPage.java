package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
                .perform(replaceText(Constants.login));
    }
    @Step("Set password")
    public void setPassword() {
        onView(withId(getPasswordTextInput()))
                .perform(replaceText(Constants.password));
    }
    @Step("Click 'SignIn' button")
    public void clickSignInButton() {
        onView(withId(getSignInButton()))
                .perform(click());
    }
}
