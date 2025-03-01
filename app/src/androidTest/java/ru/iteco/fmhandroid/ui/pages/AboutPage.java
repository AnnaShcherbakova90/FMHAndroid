package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AboutPage {
    public int versionTextView = R.id.about_version_title_text_view;
    public int privacyPolicyTextView = R.id.about_privacy_policy_label_text_view;
    public int termsOfUseTextView = R.id.about_terms_of_use_label_text_view;

    public int getVersionTextView() {
        return versionTextView;
    }
    public int getPrivacyPolicyTextView() {
        return privacyPolicyTextView;
    }
    public int getTermsOfUseTextView() {
        return termsOfUseTextView;
    }

    @Step("Check Version title exists")
    public void checkVersionExists() {
        onView(withId(getVersionTextView()))
                .check(matches(isDisplayed()));
    }
    @Step("Check Privacy policy title exists")
    public void checkPrivacyPolicyExists() {
        onView(withId(getPrivacyPolicyTextView()))
                .check(matches(isDisplayed()));
    }
    @Step("Check Terms of use title exists")
    public void checkTermsOfUseExists() {
        onView(withId(getTermsOfUseTextView()))
                .check(matches(isDisplayed()));
    }

}
