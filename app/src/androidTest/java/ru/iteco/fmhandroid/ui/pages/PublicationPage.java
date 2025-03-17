package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class PublicationPage {

    public int newItemTitleInputEditText = R.id.news_item_title_text_input_edit_text;
    public int androidButton = android.R.id.button1;
    public int newItemDescriptionInputEditText = R.id.news_item_description_text_input_edit_text;
    public int saveButton = R.id.save_button;
    public int filterActiveMaterialCheckBox = R.id.filter_news_active_material_check_box;
    public int newCategoryTextView = R.id.news_item_category_text_auto_complete_text_view;

    public int getNewItemTitleInputEditText() {
        return newItemTitleInputEditText;
    }
    public int getAndroidButton() {
        return androidButton;
    }
    public int getNewItemDescriptionInputEditText() {
        return newItemDescriptionInputEditText;
    }
    public int getSaveButton() {
        return saveButton;
    }
    public int getFilterActiveMaterialCheckBox() {
        return filterActiveMaterialCheckBox;
    }
    public int getNewCategoryTextView() {
        return newCategoryTextView;
    }

    @Step("Set New category")
    public void setNewCategory(String category) {
        onView(allOf(withId(getNewCategoryTextView()),
                isDisplayed()
        ))
                .perform(replaceText(category));
    }
    @Step("Set New title")
    public void setNewTitle(String title) {
        onView(allOf(withId(getNewItemTitleInputEditText()),
                isDisplayed()
        ))
                .perform(replaceText(title));
    }
    @Step("Set New description")
    public void setNewDescription(String description) {
        onView(allOf(withId(getNewItemDescriptionInputEditText()),
                isDisplayed()
        ))
                .perform(replaceText(description));
    }
    @Step("Click Save button")
    public void clickSaveButton() {
        onView(withId(getSaveButton()))
                .perform(click());
    }
    @Step("Check Attention button exists")
    public void checkAttentionButtonExists() {
        onView(withId(getSaveButton()))
                .perform(click());
    }

    @Step("Click Cancel button")
    public void clickCancelButton() {
        onView(withId(R.id.cancel_button))
            .perform(scrollTo(), click());

        onView(allOf(withId(android.R.id.button1), withText("OK")))
            .perform(scrollTo(), click());
    }

}
