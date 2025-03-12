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

    public int allNewsTextView = R.id.all_news_text_view;
    public int newsListContainer = R.id.container_list_news_include;

    public int getAllNewsTextView() {
        return allNewsTextView;
    }
    public int getNewsListContainer() {
        return newsListContainer;
    }
    @Step("Click 'All News' button")
    public void clickAllNewsButton(){
        onView(allOf(withId(getAllNewsTextView()),
                withText(Constants.ALL_NEWS),
                isDisplayed()
        ))
                .perform(click());
    }
    @Step("Check News line is shown")
    public void checkAllNewsResult() {
        onView(allOf(withText(Constants.NEWS),
            isDisplayed()
        ))
                .check(matches(withText(Constants.NEWS)));
    }
}
