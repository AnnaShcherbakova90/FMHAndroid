package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.utils.BasicScenarios;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class LogInOutTest {

    BasicScenarios basicScenarios = new BasicScenarios();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void checkAndLogOut() {
        basicScenarios.logOut();
    }

    @Test
    public void checkLogInPageShownTest() {
        basicScenarios.checkLogInPageShown();
    }
    @Test
    public void logInWithIncorrectLoginTest() {
        basicScenarios.logInWithIncorrectLogin();
    }
    @Test
    public void logInWithIncorrectPasswordTest() {
        basicScenarios.logInWithIncorrectPassword();
    }
    @Test
    public void logInTest() {
        basicScenarios.logIn();
    }
    @Test
    public void logOutTest() {
        basicScenarios.logOut();
    }

    @After
    public void logOut() {
        basicScenarios.logOut();
    }
}
