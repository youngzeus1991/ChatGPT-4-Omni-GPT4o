package com.scut.itpm.umo.data.announce;

import com.scut.itpm.umo.data.follow.FollowModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public class RequirementModel extends FollowModel implements Serializable {

    private int requirementID;
    private String requirementTag;
    private String requirementContent;
    private List requirementImageList;
    private int requirementValidDuration;
    private int requirementerPhotoID;
    private String requirementMoment;
//    private Location requirementLocation;
    private String requirementLocation;
    private int viewCount;
    private int bookCount;
    private int commentCount;
    private String requirementerName;

    public int getRequirementerPhotoID() {
        return requirementerPhotoID;
    }

    public void setRequirementerPhotoID(int requirementerPhotoID) {
        this.requirementerPhotoID = requirementerPhotoID;
    }

    public int getRequirementID() {
        return requirementID;
    }

    public void setRequirementID(int requirementID) {
        this.requirementID = requirementID;
    }

    public String getRequirementTag() {
        return requirementTag;
    }

    public void setRequirementTag(String requirementTag) {
        this.requirementTag = requirementTag;
    }

    public String getRequirementContent() {
        return requirementContent;
    }

    public void setRequirementContent(String requirementContent) {
        this.requirementContent = requirementContent;
    }

    public List getRequirementImageList() {
        return requirementImageList;
    }

    public void setRequirementImageList(List requirementImageList) {
        this.requirementImageList = requirementImageList;
    }

    public int getRequirementValidDuration() {
        return requirementValidDuration;
    }

    public void setRequirementValidDuration(int requirementValidDuration) {
        this.requirementValidDuration = requirementValidDuration;
    }

    public String getRequirementMoment() {
        return requirementMoment;
    }

    public void setRequirementMoment(String requirementMoment) {
        this.requirementMoment = requirementMoment;
    }

    public String getRequirementLocation() {
        return requirementLocation;
    }

    public void setRequirementLocation(String requirementLocation) {
        this.requirementLocation = requirementLocation;
    }

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getBookCount() {
        return bookCount;
    }

    public void setBookCount(int bookCount) {
        this.bookCount = bookCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public String getRequirementerName() {
        return requirementerName;
    }

    public void setRequirementerName(String requirementerName) {
        this.requirementerName = requirementerName;
    }
}
