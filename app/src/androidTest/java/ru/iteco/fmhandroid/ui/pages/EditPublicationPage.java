package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.typeTextIntoFocusedView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class EditPublicationPage extends PublicationPage {

    public int newItemPublishDateInputEditText = R.id.news_item_publish_date_text_input_edit_text;
    public int newItemPublishTimeInputEditTextLayout = R.id.news_item_publish_time_text_input_layout;
    public int newItemPublishTimeInputEditText = R.id.news_item_publish_time_text_input_edit_text;
    public int newItemCreateDateInputTextLayout = R.id.news_item_create_date_text_input_layout;
    public int activeSwitcher = R.id.switcher;

    public int getNewItemCreateDateInputTextLayout() {
        return newItemCreateDateInputTextLayout;
    }
    public int getNewItemPublishDateInputEditText() {
        return newItemPublishDateInputEditText;
    }
    public int getNewItemPublishTimeInputEditTextLayout() {
        return newItemPublishTimeInputEditTextLayout;
    }
    public int getNewItemPublishTimeInputEditText() {
        return newItemPublishTimeInputEditText;
    }
    public int getActiveSwitcher() {
        return activeSwitcher;
    }

    @Step("Set New date")
    public void setNewDate() {
        onView(allOf(withId(getNewItemCreateDateInputTextLayout()),
                isDisplayed()
        ))
                .perform(click());

        onView(withId(getNewItemPublishDateInputEditText()))
                .perform(click());

        onView(allOf(withId(getAndroidButton()),
                withText(Constants.OK)
        ))
                .perform(scrollTo(), click());
    }
    @Step("Set New time")
    public void setNewTime() {
        onView(withId(getNewItemPublishTimeInputEditTextLayout()))
                .perform(click());

        onView(withId(getNewItemPublishTimeInputEditText()))
                .perform(click());

        onView(allOf(withId(getAndroidButton()),
                withText(Constants.OK)
        ))
                .perform(scrollTo(), click());
    }
    @Step("Set Publication date")
    public void setPublicationDate(String date) {
        onView(withId(getNewItemPublishDateInputEditText()))
                .perform(clearText(), typeTextIntoFocusedView(date));
    }
    @Step("Set Publication time")
    public void setPublicationTime(String time) {
        onView(withId(getNewItemPublishTimeInputEditText()))
                .perform(clearText(), typeTextIntoFocusedView(time));
    }
    @Step("Switch Active toggle")
    public void switchActiveToggle(String state) {
        onView(withId(R.id.switcher))
                .perform(scrollTo(), click());
    }
    @Step("Check attributes have been updated")
    public void checkAttributesUpdated(String category, String title, String description, String date, String time, String activity) {
        onView(allOf(withId(getNewCategoryTextView()),
                withText(category),
                isDisplayed()
        ))
                .check(matches(withText(category)));

        onView(allOf(withId(getNewItemTitleInputEditText()),
                withText(title),
                isDisplayed()
        ))
                .check(matches(withText(title)));

        /*onView(allOf(withId(getNewItemPublishDateInputEditText()),
                withText(date),
                isDisplayed()
        ))
                .check(matches(withText(date)));

        onView(allOf(withId(getNewItemPublishTimeInputEditText()),
                withText(time),
                isDisplayed()
        ))
                .check(matches(withText(time)));*/

        onView(allOf(withId(getNewItemDescriptionInputEditText()),
                withText(description),
                isDisplayed()
        ))
                .check(matches(withText(description)));

        onView(allOf(withId(getActiveSwitcher()),
                withText(activity),
                isDisplayed()
        ))
                .check(matches(isDisplayed()));
    }
}
