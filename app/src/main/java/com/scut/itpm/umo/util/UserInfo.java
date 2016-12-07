package com.scut.itpm.umo.util;

/**
 * Created by yaoyou on 2016/12/7.
 */

public class UserInfo {
    private static String  userid;
    private static String  name;
    private static String  password;
    private static String  eamil;
    private static String  avatar;
    private static String  age;
    private static String  phone;
    private static String  sex;
    private static String  birthday;

    public static String getUserid() {
        return userid;
    }

    public static void setUserid(String userid) {
        UserInfo.userid = userid;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserInfo.name = name;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        UserInfo.password = password;
    }

    public static String getAvatar() {
        return avatar;
    }

    public static void setAvatar(String avatar) {
        UserInfo.avatar = avatar;
    }

    public static String getEamil() {
        return eamil;
    }

    public static void setEamil(String eamil) {
        UserInfo.eamil = eamil;
    }

    public static String getAge() {
        return age;
    }

    public static void setAge(String age) {
        UserInfo.age = age;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        UserInfo.phone = phone;
    }

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        UserInfo.sex = sex;
    }

    public static String getBirthday() {
        return birthday;
    }

    public static void setBirthday(String birthday) {
        UserInfo.birthday = birthday;
    }
}
