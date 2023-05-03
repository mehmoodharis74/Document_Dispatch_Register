package com.example.application_dispatcher.Constant;

public class Constants {
    public static String CURRENT_USER_EMAIL = "";
    public static Integer CURRENT_USER_ID = -1;
    public static String CURRENT_USER_NAME = "";
    public static String DATABASE_NAME = "dispatchRegister";

    public static void clearStrings() {
        CURRENT_USER_NAME = "";
        CURRENT_USER_ID = -1;
        CURRENT_USER_EMAIL= "";
    }
}
