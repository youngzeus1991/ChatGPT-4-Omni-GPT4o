package com.scut.itpm.umo.core.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.contact.ContactChildModel;
import com.scut.itpm.umo.data.contact.ContactGroupModel;

import java.util.List;

/**
 * Created by Administrator on 2016/12/1.
 */

public class ContactAdapter extends BaseExpandableListAdapter{

    private List<ContactGroupModel> list;
    private Context context;

    public ContactAdapter(List<ContactGroupModel> list, Context context){
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
            holder.groupName = (TextView)convertView.findViewById(R.id.group_name);
            holder.roundsImg = (ImageView)convertView.findViewById(R.id.rounds);
            holder.childrenNum = (TextView)convertView.findViewById(R.id.children_count);
            convertView.setTag(holder);
        }else{
            holder = (GroupHolder)convertView.getTag();
        }
        ContactGroupModel groupModel = list.get(groupPosition);

        holder.groupName.setText(groupModel.getGroupName());

        //设置分组容量
        String childrenContent = String.valueOf(getChildrenCount(groupPosition));
        holder.childrenNum.setText(childrenContent);

        if(isExpanded){
            holder.roundsImg.setImageResource(R.drawable.rounds_open);
        }else{
            holder.roundsImg.setImageResource(R.drawable.rounds_close);
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
            holder.isOnline = (TextView)convertView.findViewById(R.id.is_online);
            convertView.setTag(holder);
        }else{
            holder = (ChildHolder)convertView.getTag();
        }
        ContactChildModel childModel = list.get(groupPosition).getChildren().get(childPosition);
        holder.avatar.setImageResource(childModel.getAvatarId());
        holder.nickName.setText(childModel.getNickName());
        holder.sign.setText("sign:" + childModel.getSign());
        if(childModel.isOnline()){
            holder.isOnline.setText("[在线]");
        }else{
            holder.isOnline.setText("[离线]");
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        //it is necessary to realize ChildView onClick Event,we must return true
        return true;
    }

    private class GroupHolder {
        TextView groupName;
        ImageView roundsImg;
        TextView childrenNum;
    }

    private class ChildHolder {
        ImageView avatar;
        TextView nickName;
        TextView sign;
        TextView isOnline;
    }
}
