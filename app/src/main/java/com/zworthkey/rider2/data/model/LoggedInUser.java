package com.zworthkey.rider2.data.model;

import com.zworthkey.rider2.utils.pojoClasses.PojoUserData;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private static String userId;
    private static  String displayName;
    private static String userEmail;

    public LoggedInUser(PojoUserData pojoUserData) {
        userId = pojoUserData.getId();
        displayName = pojoUserData.getDisplayName();
        userEmail = pojoUserData.getUserEmail();
    }
    public LoggedInUser()
    {}

    public static String getUserId() {
        return userId;
    }


    public  static String getDisplayName() {
        return displayName;
    }

    public  static String getUserEmail() {
        return userEmail;
    }
}