package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class NewsListRecyclerPage {

    public int newsListRecyclerView = R.id.news_list_recycler_view;
    public int newItemTitleTextView = R.id.news_item_title_text_view;
    public int editNewsItemButton = R.id.edit_news_item_image_view;
    public int itemDescriptionTextView = R.id.news_item_description_text_view;
    public int newsItemPublishedTextView =  R.id.news_item_published_text_view;
    public int newsItemMaterialCardView =  R.id.news_item_material_card_view;
    public int deleteNewsItemButton = R.id.delete_news_item_image_view;

    public int okButton = android.R.id.button1;

    public int getEditNewsItemButton() {
        return editNewsItemButton;
    }
    public int getItemDescriptionTextView() {
        return itemDescriptionTextView;
    }
    public int getNewsListRecyclerView() {
        return newsListRecyclerView;
    }
    public int getNewItemTitleTextView() {
        return newItemTitleTextView;
    }
    public int getNewsItemPublishedTextView() {
        return newsItemPublishedTextView;
    }
    public int getNewsItemMaterialCardView() {
        return newsItemMaterialCardView;
    }
    public int getDeleteNewsItemButton() {
        return deleteNewsItemButton;
    }
    public int getOkButton() {
        return okButton;
    }

    @Step("Check created New is existent")
    public void checkNewItemTitleExists(String title) {
        onView(allOf(
                withId(getNewItemTitleTextView()),
                withText(title)
        ))
                .check(matches(withText(title)));
    }
    @Step("Check created New is existent")
    public void checkNewItemByTitleAndDescription(String title, String description) {
        onView(allOf(
                withId(getNewItemTitleTextView()),
                withText(title)
        ))
                .perform(click());

        onView(allOf(
                withId(getItemDescriptionTextView()),
                withText(description)
        ))
                .check(matches(withText(description)));
    }
    @Step("Check updated publication exists in the line")
    public void checkUpdatedPublicationExists(String category, String title, String description, String date, String time, String activity) {

        onView(allOf(withId(getNewItemTitleTextView()),
                withText(title),
                isDisplayed()
        ))
            .perform(scrollTo(), click());

        /*onView(allOf(withId(R.id.category_icon_image_view), hasDescendant(withText(title)),
                isDisplayed()))
                .check(matches(withContentDescription(category)));*/

        onView(allOf(withId(getNewItemTitleTextView()),
                withText(title),
                isDisplayed()
        ))
                .check(matches(withText(title)));

        onView(allOf(withId(getItemDescriptionTextView()),
                withText(description),
                isDescendantOfA(allOf(withId(getNewsItemMaterialCardView()), hasDescendant(withText(title)))),
                isDisplayed()
        ))
                .check(matches(withText(description)));

        /*onView(allOf(withId(R.id.news_item_publication_date_text_view),
                 withText(date),
                 hasDescendant(withText(title)),
                 isDisplayed()
        ))
                .check(matches(withText(date)));

        onView(allOf(withId(R.id.news_item_publication_date_text_view), hasDescendant(withText(title)),
                 isDisplayed()
        ))
                .check(matches(withText(time)));*/

        onView(allOf(withId(getNewsItemPublishedTextView()),
                withText(Constants.notActive.toUpperCase()),
                isDescendantOfA(allOf(withId(getNewsItemMaterialCardView()), hasDescendant(withText(title)))),
                isDisplayed()
        ))
                .check(matches(withText(Constants.notActive.toUpperCase())));
    }
    @Step("Click the first available edit button inside a parent containing the title")
    public void clickEditPublicationWithSpecificTitle(String title) {
        onView(allOf(withId(getEditNewsItemButton()),
                isDescendantOfA(allOf(withId(getNewsItemMaterialCardView()), hasDescendant(withText(title))))
        ))
                .perform(click());
    }

    public void clickDeletePublicationWithSpecificTitle(String title) {
        onView(allOf(withId(getDeleteNewsItemButton()),
                isDescendantOfA(allOf(withId(getNewsItemMaterialCardView()), hasDescendant(withText(title))))
        ))
                .perform(click());

        onView(allOf(withId(getOkButton()),
                withText(Constants.OK)
        ))
                .perform(click());
    }

    public void checkNewItemTitleDoesNotExist(String title) {
        onView(allOf(
                withId(getNewItemTitleTextView()),
                withText(title)
        ))
                .check(doesNotExist());
    }
}
