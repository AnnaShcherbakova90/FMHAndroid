package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class OurMissionPage {

    public int ourMissionTitleTextView = R.id.our_mission_title_text_view;
    public int getOurMissionTitleTextView() {
        return ourMissionTitleTextView;
    }

    @Step("Check Our mission title exists")
    public void checkOurMissionTitleExists() {
        onView(withId(getOurMissionTitleTextView()))
                .check(matches(isDisplayed()));
    }

}
