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
import ru.iteco.fmhandroid.ui.pages.NewsLinePage;
import ru.iteco.fmhandroid.ui.utils.BasicScenarios;
import ru.iteco.fmhandroid.ui.utils.CommonUtils;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class NewsLineTest {

    BasicScenarios basicScenarios = new BasicScenarios();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void logIn() {
        basicScenarios.logIn();
    }

    @Test
    public void allNewsShownTest() {
        basicScenarios.newsLineScenario();
    }

    @After
    public void logOut() {
        basicScenarios.logOut();
    }
}
