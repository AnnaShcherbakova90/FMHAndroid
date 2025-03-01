package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class FilterPublicationPage extends PublicationPage {
    public int filerButton = R.id.filter_button;
    public int newItemPublishDateStartInputEditTextLayout = R.id.news_item_publish_date_start_text_input_layout;
    public int newItemPublishDateStartInputEditText = R.id.news_item_publish_date_start_text_input_edit_text;
    public int newItemPublishDateEndInputEditTextLayout = R.id.news_item_publish_date_end_text_input_layout;
    public int newItemPublishDateEndInputEditText = R.id.news_item_publish_date_end_text_input_edit_text;
    public int filterInactiveMaterialCheckBox = R.id.filter_news_inactive_material_check_box;

    public int getFilerButton() {
        return filerButton;
    }
    public int getNewItemPublishDateStartInputEditTextLayout() {
        return newItemPublishDateStartInputEditTextLayout;
    }
    public int getNewItemPublishDateStartInputEditText() {
        return newItemPublishDateStartInputEditText;
    }
    public int getNewItemPublishDateEndInputEditTextLayout() {
        return newItemPublishDateEndInputEditTextLayout;
    }
    public int getNewItemPublishDateEndInputEditText() {
        return newItemPublishDateEndInputEditText;
    }
    public int getFilterInactiveMaterialCheckBox() {
        return filterInactiveMaterialCheckBox;
    }

    @Step("Enable Active checkbox")
    public void enableActiveCheckbox() {
        onView(allOf(withId(getFilterActiveMaterialCheckBox()),
                isDisplayed()
        ))
                .check(matches(isNotChecked()))
                .perform(click());
    }
    @Step("Disable Active checkbox")
    public void disableActiveCheckbox() {
        onView(allOf(withId(getFilterActiveMaterialCheckBox()),
                isDisplayed()
        ))
                .check(matches(isChecked()))
                .perform(click());
    }
    @Step("Enable Inactive checkbox")
    public void enableNotActiveCheckbox() {
        onView(allOf(withId(getFilterInactiveMaterialCheckBox()),
                isDisplayed()
        ))
                .check(matches(isNotChecked()))
                .perform(click());
    }
    @Step("Disable Inactive checkbox")
    public void disableNotActiveCheckbox() {
        onView(allOf(withId(getFilterInactiveMaterialCheckBox()),
                isDisplayed()
        ))
                .check(matches(isChecked()))
                .perform(click());
    }
    @Step("Click Filter button")
    public void clickFilterButton() {
        onView(allOf(withId(getFilerButton()),
                isDisplayed()
        ))
                .perform(click());
    }
    @Step("Set Start date filter")
    public void setStartDateFilter() {
        onView(withId(getNewItemPublishDateStartInputEditTextLayout()))
                .perform(click());

        onView(withId(getNewItemPublishDateStartInputEditText()))
                .perform(click());

        onView(allOf(withId(getAndroidButton()),
                withText(Constants.OK)
        ))
                .perform(scrollTo(), click());
    }
    @Step("Set End date filter")
    public void setEndDateFilter() {
        onView(withId(getNewItemPublishDateEndInputEditTextLayout()))
                .perform(click());

        onView(withId(getNewItemPublishDateEndInputEditText()))
                .perform(click());

        onView(allOf(withId(getAndroidButton()),
                withText(Constants.OK)
        ))
                .perform(scrollTo(), click());
    }
}
