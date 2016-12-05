package com.scut.itpm.umo.data.announce;

import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public class FeelingModel {
    private int feelingerPhotoResID;
    private int feelingID;
    private String feelingContent;
    private List feelingImageList;
    private String feelingMoment;
//    private Location feelingLocation;
    private String feelingLocation;
    private int viewCount;
    private int commendCount;
    private int commentCount;
    private String feelingerName;

    public int  getFeelingerPhoto() {
        return feelingerPhotoResID;
    }

    public void setFeelingerPhotoID(int  feelingerPhoto) {
        this.feelingerPhotoResID = feelingerPhoto;
    }

    public String getFeelingContent() {
        return feelingContent;
    }

    public void setFeelingContent(String feelingContent) {
        this.feelingContent = feelingContent;
    }

    public int getFeelingID() {
        return feelingID;
    }

    public void setFeelingID(int feelingID) {
        this.feelingID = feelingID;
    }

    public String getFeelingMoment() {
        return feelingMoment;
    }

    public void setFeelingMoment(String dateString) {
        this.feelingMoment = dateString;
    }

    public List getFeelingImageList() {
        return feelingImageList;
    }

    public void setFeelingImageList(List feelingImageList) {
        this.feelingImageList = feelingImageList;
    }

    public String getFeelingLocation() {
        return feelingLocation;
    }

    public void setFeelingLocation(String feelingLocation) {
        this.feelingLocation = feelingLocation;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getCommendCount() {
        return commendCount;
    }

    public void setCommendCount(int commendCount) {
        this.commendCount = commendCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getFeelingerName() {
        return feelingerName;
    }

    public void setFeelingerName(String feelingerName) {
        this.feelingerName = feelingerName;
    }
}
