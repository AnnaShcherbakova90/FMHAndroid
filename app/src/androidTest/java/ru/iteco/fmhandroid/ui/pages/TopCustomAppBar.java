package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import androidx.test.espresso.matcher.ViewMatchers;
import org.hamcrest.Matchers;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class TopCustomAppBar {

    public static int getAuthImageButton() {
        return R.id.authorization_image_button;
    }

    public static int getTitle() {
        return android.R.id.title;
    }

    public static int getLogOutItem() {
        return R.id.authorization_logout_menu_item;
    }

    @Step("Click 'AuthImage' button")
    public static void clickAuthImageButton() {
        onView(withId(getAuthImageButton()))
                .perform(click());
    }

    @Step("Click 'Log out' menu option")
    public static void clickLogOut() {
        onView(Matchers.allOf(withId(getTitle()), ViewMatchers.withText(Constants.logOut),
                isDisplayed()))
                .perform(click());
    }

}
