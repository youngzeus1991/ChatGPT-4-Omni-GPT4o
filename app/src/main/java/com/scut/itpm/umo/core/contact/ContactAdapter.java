package com.scut.itpm.umo.core.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.scut.itpm.umo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class ContactAdapter extends BaseExpandableListAdapter{

    private List<GroupBean> list;
    private Context context;
/**
    public Context getContext() {
        return context;
    }
**/
    public ContactAdapter(List<GroupBean> list,Context context){
        this.context = context;
        this.list = list;
    }

    public ContactAdapter(){
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(groupPosition).getChildren().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getChildren().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        GroupHolder holder;
        if(convertView == null){
            holder = new GroupHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_group,null);
            holder.title = (TextView)convertView.findViewById(R.id.group_title);
            holder.avatar = (ImageView)convertView.findViewById(R.id.rounds);
            convertView.setTag(holder);
        }else{
            holder = (GroupHolder)convertView.getTag();
        }
        holder.title.setText(list.get(groupPosition).getGroupName());
        if(isExpanded){
            holder.avatar.setImageResource(R.drawable.rounds_open);
        }else{
            holder.avatar.setImageResource(R.drawable.rounds_close);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isExpanded, View convertView, ViewGroup parent) {
        ChildHolder holder;
        if(convertView == null){
            holder = new ChildHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child,null);
            holder.avatar = (ImageView)convertView.findViewById(R.id.child_avatar);
            holder.nickName = (TextView)convertView.findViewById(R.id.child_name);
            holder.sign = (TextView)convertView.findViewById(R.id.child_sign);
            convertView.setTag(holder);
        }else{
            holder = (ChildHolder)convertView.getTag();
        }
        ChildBean childBean = list.get(groupPosition).getChildren().get(childPosition);
        holder.avatar.setImageResource(childBean.getImgId());
        holder.nickName.setText(childBean.getNickName());
        holder.sign.setText(context.getString(R.string.user_info) + childBean.getSign());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    private class GroupHolder {
        TextView title;
        ImageView avatar;
    }

    private class ChildHolder {
        ImageView avatar;
        TextView nickName;
        TextView sign;
    }
}
