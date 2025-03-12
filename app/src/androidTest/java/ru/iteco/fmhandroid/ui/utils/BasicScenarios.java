package ru.iteco.fmhandroid.ui.utils;

import ru.iteco.fmhandroid.ui.data.Constants;
import ru.iteco.fmhandroid.ui.pages.AboutPage;
import ru.iteco.fmhandroid.ui.pages.EditPublicationPage;
import ru.iteco.fmhandroid.ui.pages.FilterPublicationPage;
import ru.iteco.fmhandroid.ui.pages.NewsControlPanel;
import ru.iteco.fmhandroid.ui.pages.NewsLinePage;
import ru.iteco.fmhandroid.ui.pages.NewsListRecyclerPage;
import ru.iteco.fmhandroid.ui.pages.OurMissionPage;

public class BasicScenarios extends CommonUtils {

    NewsControlPanel newsControlPanel = new NewsControlPanel();
    NewsLinePage newsLinePage = new NewsLinePage();
    EditPublicationPage editPublicationPage = new EditPublicationPage();
    FilterPublicationPage filterPublicationPage = new FilterPublicationPage();
    NewsListRecyclerPage newsListRecyclerPage = new NewsListRecyclerPage();
    AboutPage aboutPage = new AboutPage();
    OurMissionPage ourMissionPage = new OurMissionPage();

    public void logIn() {
        if(!isLoggedIn()) {
            authPage.setLogin();
            authPage.setPassword();
            authPage.clickSignInButton();
        }
    }
    public void logInError() {
        if(!isLoggedIn()) {
            authPage.setWrongLogin();
            authPage.setWrongPassword();
            authPage.clickSignInButton();
            authPage.checkErrorAppears();
        }
    }
    public void logOut() {
        if(isLoggedIn()) {
            topCustomAppBar.clickAuthImageButton();
            topCustomAppBar.clickLogOut();
            waitDisplayed(authPage.getLoginTextInput());
        }
    }
    public void createPublicationScenario() {
        waitDisplayed(newsLinePage.getAllNewsTextView());
        newsLinePage.clickAllNewsButton();
        newsControlPanel.clickEditNewButton();
        newsControlPanel.clickAddNewButton();
        waitDisplayed(editPublicationPage.getNewCategoryTextView());
        editPublicationPage.setNewCategory(Constants.PUBLICATION);
        editPublicationPage.setNewTitle(Constants.getTITLE());
        editPublicationPage.setNewDate();
        editPublicationPage.setNewTime();
        editPublicationPage.setNewDescription(Constants.getDESCRIPTION());
        editPublicationPage.clickSaveButton();
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsListRecyclerPage.checkNewItemTitleExists(Constants.getTITLE());
    }
    public void editPublicationScenario() {
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsListRecyclerPage.clickEditPublicationWithSpecificTitle(Constants.getTITLE());
        waitDisplayed(editPublicationPage.getNewCategoryTextView());
        editPublicationPage.setNewTitle(Constants.getNewTitle());
        editPublicationPage.setNewDescription(Constants.getNewDescription());
        editPublicationPage.setNewCategory(Constants.SALARY);
        //editPublicationPage.setPublicationDate(Constants.date);
        //editPublicationPage.setPublicationTime(Constants.time);
        editPublicationPage.switchActiveToggle(Constants.NOT_ACTIVE);
        editPublicationPage.clickSaveButton();
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsListRecyclerPage.clickEditPublicationWithSpecificTitle(Constants.getNewTitle());
        waitDisplayed(editPublicationPage.getNewCategoryTextView());
        editPublicationPage.checkAttributesUpdated(Constants.SALARY, Constants.getNewTitle(), Constants.getNewDescription(), Constants.DATE, Constants.TITLE, Constants.NOT_ACTIVE);
        editPublicationPage.clickSaveButton();
    }
    public void filterPublicationScenario() {
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsControlPanel.clickFilterNewsButton();
        waitDisplayed(filterPublicationPage.getNewCategoryTextView());
        filterPublicationPage.setNewCategory(Constants.PUBLICATION);
        filterPublicationPage.setStartDateFilter();
        filterPublicationPage.setEndDateFilter();
        filterPublicationPage.disableNotActiveCheckbox();
        filterPublicationPage.clickFilterButton();
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsListRecyclerPage.checkNewItemTitleExists(Constants.getTITLE());

    }
    public void sortPublicationScenario() {
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsControlPanel.clickSortNewsButton();
        newsListRecyclerPage.checkNewItemTitleExists(Constants.getTITLE());
    }
    public void checkAboutInfoExistsScenario() {
        waitDisplayed(newsLinePage.getAllNewsTextView());
        topCustomAppBar.clickAboutMenuItem();
        waitDisplayed(aboutPage.getVersionTextView());
        aboutPage.checkVersionExists();
        aboutPage.checkPrivacyPolicyExists();
        aboutPage.checkTermsOfUseExists();
    }
    public void checkOurMissionScenario() {
        waitDisplayed(newsLinePage.getAllNewsTextView());
        topCustomAppBar.clickOurMissionButton();
        waitDisplayed(ourMissionPage.getOurMissionTitleTextView());
        ourMissionPage.checkOurMissionTitleExists();
    }
    public void deletePublicationScenario() {
        waitDisplayed(newsListRecyclerPage.getNewItemTitleTextView());
        newsListRecyclerPage.clickDeletePublicationWithSpecificTitle(Constants.getTITLE());
        newsListRecyclerPage.checkNewItemTitleDoesNotExist(Constants.getTITLE());
    }

    public void newsLineScenario() {
        waitDisplayed(newsLinePage.getAllNewsTextView());
        newsLinePage.clickAllNewsButton();
        newsLinePage.checkAllNewsResult();
    }
}
