package ru.iteco.fmhandroid.ui.data;

import java.util.UUID;

public class Constants {
    public static final String LOGIN = "login2";
    public static final String WRONG_LOGIN = "wrongLogin";
    public static final String PASSWORD = "password2";
    public static final String WRONG_PASSWORD = "wrongPassword";
    public static final String LOG_OUT = "Log out";
    public static final String ALL_NEWS = "ALL NEWS";
    public static final String NEWS = "News";
    public static final String PUBLICATION = "Объявление";
    public static final String SALARY = "Зарплата";
    public static final String OK = "OK";
    public static String TITLE;
    public static String DESCRIPTION;
    public static String NEW_TITLE;
    public static String NEW_DESCRIPTION;
    public static String ACTIVE = "Active";
    public static String NOT_ACTIVE = "Not active";
    public static String DATE = "01.01.2025";
    public static String TIME = "15:00";
    public static String MAIN_MENU = "Main menu";
    public static String ABOUT = "About";

    public static String getTITLE() {
        return TITLE;
    }
    public static String getNewTitle() {
        return NEW_TITLE;
    }
    public static String getDESCRIPTION() {
        return DESCRIPTION;
    }
    public static String getNewDescription() {
        return NEW_DESCRIPTION;
    }

    public static void initialize() {
        if (TITLE == null) {
            TITLE = "TestTitle_" + UUID.randomUUID().toString();
        }
        if (NEW_TITLE == null) {
            NEW_TITLE = "NewTestTitle_" + UUID.randomUUID().toString();
        }
        if (DESCRIPTION == null) {
            DESCRIPTION = "TestDescription_" + UUID.randomUUID().toString();
        }
        if (NEW_DESCRIPTION == null) {
            NEW_DESCRIPTION = "NewTestDescription_" + UUID.randomUUID().toString();
        }
    }

    // Clear the variable after test execution
    public static void clear() {
        TITLE = null;
        NEW_TITLE = null;
        DESCRIPTION = null;
        NEW_DESCRIPTION = null;
    }
}
