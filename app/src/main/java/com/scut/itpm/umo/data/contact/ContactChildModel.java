package com.scut.itpm.umo.data.contact;

/**
 * 子列表的实体类
 * Created by Administrator on 2016/12/2.
 */
public class ContactChildModel {

    private int avatarId;
    private String nickName;
    private String sign;
    private boolean isOnline;

    public int getAvatarId(){
        return avatarId;
    }

    public void setAvatarId(int avatarId){
        this.avatarId = avatarId;
    }

    public String getNickName(){
        return nickName;
    }

    public void setNickName(String nickName){
        this.nickName = nickName;
    }

    public String getSign(){
        return sign;
    }

    public void setSign(String sign){
        this.sign = sign;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public ContactChildModel(int avatarId, String nickName, String sign, boolean isOnline){
        this.avatarId = avatarId;
        this.nickName = nickName;
        this.sign = sign;
        this.isOnline = isOnline;
    }

    public ContactChildModel(){

    }
}
