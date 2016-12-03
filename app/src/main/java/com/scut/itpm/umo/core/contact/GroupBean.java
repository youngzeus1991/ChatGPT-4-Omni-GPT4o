package com.scut.itpm.umo.core.contact;

import java.util.List;

/**
 * 创建子列表的分组类
 * Created by Administrator on 2016/12/1.
 */
public class GroupBean {

    private String groupName;
    private List<ChildBean> children;

    public String getGroupName(){
        return groupName;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public List<ChildBean> getChildren(){
        return children;
    }

    public void setChildren(List<ChildBean> children){
        this.children = children;
    }

    public GroupBean(String groupName,List<ChildBean> children){
        this.groupName = groupName;
        this.children = children;
    }

    public GroupBean(){

    }
}
