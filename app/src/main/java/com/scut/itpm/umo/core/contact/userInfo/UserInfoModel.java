package com.scut.itpm.umo.core.contact.userInfo;

/**
 * Created by Administrator on 2016/12/5.
 */

public class UserInfoModel {
    private String userID;
    private String nickName;
    private String email;
    private int avatarId;
    private int age;
    private String characteristic;
    private String remark;
    private String area;
    private int onlineStatus;
    private String contactPhoneNumber;
    private String sex;
    private String birthday;
    private String palDeclaration;
    private int loveStatus;
    private final int VISIBLE = 0;//VISIBLE为0时对其他用户不可见，1为对其他用户可见

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAvatarId() {
        return avatarId;
    }

    public void setAvatarId(int avatarId) {
        this.avatarId = avatarId;
    }

    public String getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(String characteristic) {
        this.characteristic = characteristic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPalDeclaration() {
        return palDeclaration;
    }

    public void setPalDeclaration(String palDeclaration) {
        this.palDeclaration = palDeclaration;
    }

    public int getLoveStatus() {
        return loveStatus;
    }

    public void setLoveStatus(int loveStatus) {
        this.loveStatus = loveStatus;
    }

    public int getVISIBLE() {
        return VISIBLE;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
}
