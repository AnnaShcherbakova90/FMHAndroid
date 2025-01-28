package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.utils.CommonUtils.waitDisplayed;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.TopCustomAppBar;
import ru.iteco.fmhandroid.ui.pages.AuthPage;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LogInOutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void logInOutTest() {

        //log in check

        waitDisplayed(AuthPage.getLoginInputText());

        AuthPage.setLogin();
        AuthPage.setPassword();
        AuthPage.clickSignInButton();

        waitDisplayed(TopCustomAppBar.getAuthImageButton());

        //log out check
        TopCustomAppBar.clickAuthImageButton();
        TopCustomAppBar.clickLogOut();

        waitDisplayed(AuthPage.getLoginInputText());
    }
}
