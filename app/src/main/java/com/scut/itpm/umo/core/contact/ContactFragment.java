package com.scut.itpm.umo.core.contact;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.contact.ContactChildModel;
import com.scut.itpm.umo.data.contact.ContactGroupModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by DELL on 2016/11/2.
 */

public class ContactFragment extends Fragment implements ContactContract.View{

    private ContactContract.Presenter contactPresenter;
    private List<ContactGroupModel> contactGroupModelList;

    private PopupWindow popupwindow;

    public static ContactFragment newInstance(){
        return new ContactFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_contact,null);

        initContactGroupModel();

        ExpandableListView contactListView = (ExpandableListView)view.findViewById(R.id.contact_listview);
        final ContactAdapter contactAdapter = new ContactAdapter(contactGroupModelList,getContext());
        contactListView.setAdapter(contactAdapter);
        contactListView.setGroupIndicator(null);//表示不使用系统提供的展开和收起图标
        contactListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView,
                                        View view, int groupPosition, int childPosition, long childId) {
                ContactChildModel childModel = (ContactChildModel) contactAdapter.getChild(groupPosition,childPosition);

                showPopup();
                Toast.makeText(getContext(),"hello ,"+childModel.getNickName(),Toast.LENGTH_SHORT).show();

                return true;
            }
        });

        return view;
    }

    private void showPopup() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_userinfo_detail,null);
        popupwindow = new PopupWindow(getContext());//初始化popupWindow对象
        popupwindow.setContentView(view);//设置布局文件
        popupwindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);//设置宽度
        popupwindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);//设置高度
        Toast.makeText(getContext(),"我点了，可惜没反应",Toast.LENGTH_SHORT).show();
    }

    /**
     * 要限制头像大小，分辨率太大会使内存泄漏
     */
    private void initContactGroupModel() {
        contactGroupModelList = new ArrayList<>();
        {
            List<ContactChildModel> followedList = new ArrayList<>();
            ContactChildModel ccm1 = new ContactChildModel(R.drawable.avatar_2,"李杭澍","找一个人",true);
            ContactChildModel ccm2 = new ContactChildModel(R.drawable.avatar_3,"张小贤","找一个人",false);
            ContactChildModel ccm3 = new ContactChildModel(R.drawable.avatar_1,"梁耀友","找一个人",false);
            followedList.add(ccm1);
            followedList.add(ccm2);
            followedList.add(ccm3);
            ContactGroupModel cgm1 = new ContactGroupModel("关注的人",followedList);
            contactGroupModelList.add(cgm1);
        }

        {
            List<ContactChildModel> strangerList = new ArrayList<>();
            ContactChildModel ccm1 = new ContactChildModel(R.drawable.avatar_1,"李杭澍","找一个人",true);
            ContactChildModel ccm2 = new ContactChildModel(R.drawable.avatar_2,"张小贤","找一个人",false);
            strangerList.add(ccm1);
            strangerList.add(ccm2);
            ContactGroupModel cgm1 = new ContactGroupModel("陌生人",strangerList);
            contactGroupModelList.add(cgm1);
        }

        {
            List<ContactChildModel> shieldedList = new ArrayList<>();
            ContactChildModel ccm1 = new ContactChildModel(R.drawable.avatar_3,"李沆澍","找一个人",true);
            shieldedList.add(ccm1);
            ContactGroupModel cgm1 = new ContactGroupModel("黑名单",shieldedList);
            contactGroupModelList.add(cgm1);
        }
    }

    @Override
    public void onResume() {
        Log.e("ContactFragment:","onResume");
        super.onResume();
    }

    @Override
    public void showContactGroupModelList(List<ContactGroupModel> contactGroupModelList) {
        //TODO 展示分组界面的数据
    }

    /**
     * 展示界面未获得数据时的提示
     */
    @Override
    public void showNoContactGroupModelList() {
        Toast.makeText(getContext(),"获取数据失败，请刷新页面",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(Object presenter) {
        this.contactPresenter = (ContactContract.Presenter)presenter;
    }
}
