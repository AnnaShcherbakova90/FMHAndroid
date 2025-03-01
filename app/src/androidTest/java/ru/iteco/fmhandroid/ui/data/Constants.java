package ru.iteco.fmhandroid.ui.data;

import java.util.UUID;

public class Constants {
    public static final String login = "login2";
    public static final String password = "password2";
    public static final String logOut = "Log out";
    public static final String allNews = "ALL NEWS";
    public static final String news = "News";
    public static final String publication = "Объявление";
    public static final String salary = "Зарплата";
    public static final String OK = "OK";
    public static String title;
    public static String description;
    public static String new_title;
    public static String new_description;
    public static String active = "Active";
    public static String notActive = "Not active";
    public static String date = "01.01.2025";
    public static String time = "15:00";
    public static String mainMenu = "Main menu";
    public static String about = "About";

    public static String getTitle() {
        return title;
    }
    public static String getNewTitle() {
        return new_title;
    }
    public static String getDescription() {
        return description;
    }
    public static String getNewDescription() {
        return new_description;
    }

    public static void initialize() {
        if (title == null) {
            title = "TestTitle_" + UUID.randomUUID().toString();
        }
        if (new_title == null) {
            new_title = "NewTestTitle_" + UUID.randomUUID().toString();
        }
        if (description == null) {
            description = "TestDescription_" + UUID.randomUUID().toString();
        }
        if (new_description == null) {
            new_description = "NewTestDescription_" + UUID.randomUUID().toString();
        }
    }

    // Clear the variable after test execution
    public static void clear() {
        title = null;
        new_title = null;
        description = null;
        new_description = null;
    }
}
