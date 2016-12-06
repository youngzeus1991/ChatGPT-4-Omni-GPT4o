package com.scut.itpm.umo.core.contact;

import com.scut.itpm.umo.R;

/**
 * 子列表的实体类
 * Created by Administrator on 2016/12/2.
 */
public class ChildBean {

    private int imgId;
    private String nickName;
    private String sign;

    public int getImgId(){
        return imgId;
    }

    public void setImgId(int imgId){
        this.imgId = imgId;
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

    public ChildBean(int imgId,String nickName,String sign){
        this.imgId = imgId;
        this.nickName = nickName;
        this.sign = sign;
    }

    public ChildBean(){

    }
}
