package com.scut.itpm.umo.data.contact;

import java.util.List;

/**
 * 创建子列表的分组类
 * Created by Administrator on 2016/12/1.
 */
public class ContactGroupModel {

    private String groupName;

    private List<ContactChildModel> children;

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public List<ContactChildModel> getChildren(){
        return children;
    }

    public void setChildren(List<ContactChildModel> children){
        this.children = children;
    }

    public ContactGroupModel(String groupName, List<ContactChildModel> children){
        this.groupName = groupName;
        this.children = children;
    }

    public ContactGroupModel(){

    }
}
