package com.scut.itpm.umo.core.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.chat.ChatActivity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/11/2.
 */

public class MessageFragment extends Fragment implements MessageContract.View{
    Context context;
    private MessageContract.Presenter messagePresenter;
    private static ListView listview;

    private SimpleAdapter adapter;


    public static MessageFragment newInstance(Context s){
        MessageFragment messageFragment = new MessageFragment();
        messageFragment.setContext(s);
        return messageFragment;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        listview = (ListView) findViewByID(R.layout.messagelist);
        View view= inflater.inflate(R.layout.fragment_message,null);
        listview =(ListView) view.findViewById(R.id.MessageList);
        return view;
    }
    @Override
    public void onResume() {
        Log.e("MessageFragment:","onResume");
        super.onResume();
        messagePresenter.start();
    }

    @Override
    public void setPresenter(Object presenter) {
        messagePresenter = (MessageContract.Presenter)presenter;
    }

    @Override
    public void showMessageList(final List<Map<String,Object>> messageModelList) {
        adapter = new SimpleAdapter(context,messageModelList, R.layout.messagelist,
                            new String[]{"title","info","img","time"},
                            new int[]{R.id.title, R.id.info, R.id.img, R.id.time});
        listview.setAdapter(adapter);

        //设置点击事件
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView listView = (ListView)parent;
                HashMap<String, String> map = (HashMap<String, String>) listView.getItemAtPosition(position);
                String title = map.get("title");

                Intent intent=new Intent(getContext(), ChatActivity.class);
                
                intent.putExtra("name",title);
                startActivity(intent);

            }
        });
    }

    @Override
    public void showNOMessageList() {

    }

    @Override
    public void send_later() {

    }
}
