package com.scut.itpm.umo.data.message;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class MessageModel {
    private int MessageID;
    private String ContactName;
    private String img;
    private int LastestTime;
    private String LastestMes;

    public void setMessageID(int messageID) { MessageID = messageID; }

    public int getMessageID() { return MessageID; }

    public void setImg(String img) {this.img = img;}

    public String getImg() {return img;}

    public void setContactName(String contactName) {ContactName = contactName;}

    public String getContactName() {return ContactName;}

    public int getLastestTime() {return LastestTime;}

    public void setLastestTime(int lastestTime) {LastestTime = lastestTime;}

    public void setLastestMes(String lastestMes) {LastestMes = lastestMes;}

    public String getLastestMes() {return LastestMes;}
}
