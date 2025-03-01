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
public class CreatePublicationTest {

    BasicScenarios basicScenarios = new BasicScenarios();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setup() {
        basicScenarios.logIn();
        Constants.initialize();
    }

    @Test
    public void newCreationTest() {
        basicScenarios.createPublicationScenario();
    }

    @After
    public void tearDown() {
        basicScenarios.logOut();
        Constants.clear();
    }
}
