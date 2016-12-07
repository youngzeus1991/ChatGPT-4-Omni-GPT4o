package com.scut.itpm.umo.data.chat;

/**
 * Created by yaoyou on 2016/12/1.
 */

public class ChatMessageModel {
    private static final String TAG = ChatMessageModel.class.getSimpleName();

    private String ID;//用户ID

    private String img;//头像

    private String date;//日期

    private String text;//聊天内容

    private boolean isComMeg = true;//是否为对方发来的信息

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean getMsgType() {
        return isComMeg;
    }

    public void setMsgType(boolean isComMsg) {
        isComMeg = isComMsg;
    }

    public ChatMessageModel() {
    }

    public ChatMessageModel(String img, String date, String text, boolean isComMsg) {
        this.img = img;
        this.date = date;
        this.text = text;
        this.isComMeg = isComMsg;
    }
}
