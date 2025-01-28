package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.utils.CommonUtils.waitDisplayed;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.NewsLinePage;
import ru.iteco.fmhandroid.ui.pages.TopCustomAppBar;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AllNewsShownTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logIn() {
        waitDisplayed(AuthPage.getLoginInputText());

        AuthPage.setLogin();
        AuthPage.setPassword();
        AuthPage.clickSignInButton();
    }

    @Test
    public void allNewsShownTest() {
        waitDisplayed(NewsLinePage.getAllNewsTextView());
        NewsLinePage.clickAllNewsButton();
        NewsLinePage.checkAllNewsResult();
    }

    @After
    public void logOut() {
        waitDisplayed(TopCustomAppBar.getAuthImageButton());

        TopCustomAppBar.clickAuthImageButton();
        TopCustomAppBar.clickLogOut();

        waitDisplayed(AuthPage.getLoginInputText());
    }
}
