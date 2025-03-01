package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import org.hamcrest.Matchers;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class TopCustomAppBar {

    public int authImageButton = R.id.authorization_image_button;
    public int title = android.R.id.title;
    public int logOutItem = R.id.authorization_logout_menu_item;
    public int mainMenuButton = R.id.main_menu_image_button;
    public int aboutMainMenuItem = android.R.id.title;
    public int ourMissionButton = R.id.our_mission_image_button;

    public int getAuthImageButton() {
        return authImageButton;
    }
    public int getTitle() {
        return title;
    }
    public int getLogOutItem() {
        return logOutItem;
    }
    public int getMainMenuButton() {
        return mainMenuButton;
    }
    public int getAboutMainMenuItem() {
        return aboutMainMenuItem;
    }
    public int getOurMissionButton() {
        return ourMissionButton;
    }

    @Step("Click 'AuthImage' button")
    public void clickAuthImageButton() {
        onView(withId(getAuthImageButton()))
                .perform(click());
    }
    @Step("Click 'Log out' menu option")
    public void clickLogOut() {
        onView(Matchers.allOf(withId(getTitle()),
                withText(Constants.logOut),
                isDisplayed()
        ))
                .perform(click());
    }
    @Step("Click About menu item")
    public void clickAboutMenuItem() {
        onView(allOf(withId(getMainMenuButton()), withContentDescription(Constants.mainMenu),
                        isDisplayed()
        ))
                .perform(click());

        onView(allOf(withId(getAboutMainMenuItem()),
                withText(Constants.about),
                isDisplayed()
        ))
                .perform(click());
    }
    @Step("Click Our mission button")
    public void clickOurMissionButton() {
        onView(allOf(withId(getOurMissionButton()),
                isDisplayed()
        ))
                .perform(click());
    }
}
