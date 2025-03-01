package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class NewsControlPanel {
    public int editNewButton = R.id.edit_news_material_button;
    public int addNewButton = R.id.add_news_image_view;
    public int filerNewButton = R.id.filter_news_material_button;
    public int sortNewButton = R.id.sort_news_material_button;

    public int getEditNewButton() {
        return editNewButton;
    }
    public int getAddNewButton() {
        return addNewButton;
    }
    public int getFilerNewButton() {
        return filerNewButton;
    }
    public int getSortNewButton() {
        return sortNewButton;
    }

    @Step("Click Edit News button")
    public void clickEditNewButton() {
        onView(allOf(withId(getEditNewButton()),
            isDisplayed()
        ))
                .perform(click());
    }
    @Step("Click Add New button")
    public void clickAddNewButton() {
        onView(withId(getAddNewButton()))
                .perform(click());
    }
    @Step("Click Filter News button")
    public void clickFilterNewsButton() {
        onView(allOf(withId(getFilerNewButton()),
            isDisplayed()
        ))
                .perform(click());
    }
    @Step("Click Sort News button")
    public void clickSortNewsButton() {
        onView(allOf(withId(getSortNewButton()),
                isDisplayed()
        ))
                .perform(click(), click());
    }
}
