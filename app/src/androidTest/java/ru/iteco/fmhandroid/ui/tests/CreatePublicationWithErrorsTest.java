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
import ru.iteco.fmhandroid.ui.data.Constants;
import ru.iteco.fmhandroid.ui.utils.BasicScenarios;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class CreatePublicationWithErrorsTest {

    BasicScenarios basicScenarios = new BasicScenarios();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setup() {
        Constants.initialize();
        basicScenarios.logIn();
    }

    @Test
    public void newCreationWithoutCategoryTest() {
        basicScenarios.createPublicationWithoutCategoryScenario();
    }

    @Test
    public void newCreationWithoutTitleTest() {
        basicScenarios.createPublicationWithoutTitleScenario();
    }

    @Test
    public void newCreationWithoutDateTest() {
        basicScenarios.createPublicationWithoutDateScenario();
    }

    @Test
    public void newCreationWithoutTimeTest() {
        basicScenarios.createPublicationWithoutTimeScenario();
    }

    @Test
    public void newCreationWithoutDescriptionTest() {
        basicScenarios.createPublicationWithoutDescriptionScenario();
    }

    @After
    public void tearDown() {
        basicScenarios.logOut();
        Constants.clear();
    }
}
