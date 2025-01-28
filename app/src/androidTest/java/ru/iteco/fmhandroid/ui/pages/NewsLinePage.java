package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.Constants;

public class NewsLinePage {

    public static int getAllNewsTextView() {
        return R.id.all_news_text_view;
    }

    public static int getNewsListContainer() {
        return R.id.container_list_news_include;
    }
    @Step("Click 'All News' button")
    public static void clickAllNewsButton(){
        onView(allOf(withId(getAllNewsTextView()), withText(Constants.allNews),
            isDisplayed()))
            .perform(click());
    }

    @Step("Check News line is shown")
    public static void checkAllNewsResult() {
        onView(allOf(withText(Constants.news),
            isDisplayed()))
            .check(matches(withText(Constants.news)));
    }
}
