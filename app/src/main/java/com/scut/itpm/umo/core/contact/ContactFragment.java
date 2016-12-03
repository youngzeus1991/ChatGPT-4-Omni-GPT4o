package com.scut.itpm.umo.core.contact;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.scut.itpm.umo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public class ContactFragment extends Fragment {

    private ExpandableListView contactListView;
    private ContactAdapter contactAdapter;
    private List<GroupBean> contactList;

    public static ContactFragment newInstance(){
        return new ContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_contact,null);
        initContactData();
        contactListView = (ExpandableListView)view.findViewById(R.id.contact_listview);
        contactAdapter = new ContactAdapter(contactList,getContext());
        contactListView.setAdapter(contactAdapter);
        contactListView.setGroupIndicator(null);//表示不使用系统提供的展开和收起图标

        return view;
    }

    private void initContactData() {
        contactList = new ArrayList<GroupBean>();
        {
            List<ChildBean> followedList = new ArrayList<ChildBean>();
            ChildBean cb1 = new ChildBean(R.drawable.avatar_6,"李沆澍","找一个人");
            ChildBean cb2 = new ChildBean(R.drawable.avatar_2,"张小贤","找一个人");
            ChildBean cb3 = new ChildBean(R.drawable.avatar_7,"梁耀友","找一个人");
            followedList.add(cb1);
            followedList.add(cb2);
            followedList.add(cb3);
            GroupBean gb1 = new GroupBean("关注的人",followedList);
            contactList.add(gb1);
        }

        {
            List<ChildBean> strangerList = new ArrayList<ChildBean>();
            ChildBean cb1 = new ChildBean(R.drawable.avatar_4,"李沆澍","找一个人");
            ChildBean cb2 = new ChildBean(R.drawable.avatar_5,"张小贤","找一个人");
            ChildBean cb3 = new ChildBean(R.drawable.avatar_3,"梁耀友","找一个人");
            strangerList.add(cb1);
            strangerList.add(cb2);
            strangerList.add(cb3);
            GroupBean gb1 = new GroupBean("陌生人",strangerList);
            contactList.add(gb1);
        }

        {
            List<ChildBean> shieldedList = new ArrayList<ChildBean>();
            ChildBean cb1 = new ChildBean(R.drawable.avatar_4,"李沆澍","找一个人");
            ChildBean cb2 = new ChildBean(R.drawable.avatar_5,"张小贤","找一个人");
            ChildBean cb3 = new ChildBean(R.drawable.avatar_3,"梁耀友","找一个人");
            shieldedList.add(cb1);
            shieldedList.add(cb2);
            shieldedList.add(cb3);
            GroupBean gb1 = new GroupBean("黑名单",shieldedList);
            contactList.add(gb1);
        }
    }

    @Override
    public void onResume() {
        Log.e("ContactFragment:","onResume");
        super.onResume();
    }
}
