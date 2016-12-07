package com.scut.itpm.umo.util;

/**
 * Created by DELL on 2016/12/6.
 */

public class UserUtil {
    private static int USER_ID;

    public static void setUserId(int userId) {
        USER_ID = userId;
    }

    public static int getUserID(){
        return USER_ID;
    }
}
