package com.scut.itpm.umo.chat.down;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.chat.ChatMessageModel;

import java.util.List;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class chatDownView extends RelativeLayout implements chatDownConstract.View{

    private chatDownConstract.Presenter presenter;


    private Button sendbtn;
    private ImageButton morebtn;
    private EditText edit;
    private ListView listView;
    private View view;
    private RelativeLayout chatdown_lay;
    private ChatMsgViewAdpater adapter;
    private Context context;
    private PopupWindow drawer;

    public chatDownView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView(context);

    }

    public chatDownView(Context context) {
        super(context);
        initView(context);
    }

    public chatDownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        view = View.inflate(context, R.layout.layout_chatdown, this);
        sendbtn = (Button) view.findViewById(R.id.id_send);
        morebtn = (ImageButton) view.findViewById(R.id.id_more);
        edit = (EditText) view.findViewById(R.id.id_editText);
        listView = (ListView) view.findViewById(R.id.id_listview);

        chatdown_lay = (RelativeLayout) view.findViewById(R.id.chatdown_view);
    }

    @Override
    public void setPresenter(Object presenter) {
        this.presenter=(chatDownPresenter)presenter;
    }

    @Override
    public void showChatMsgList(List<ChatMessageModel> chatMsgList) {
        adapter = new ChatMsgViewAdpater(context,chatMsgList);
        listView.setAdapter(adapter);

        listView.setDivider(null);//去除边框
    }

    @Override
    public void NoChatMsgListt() {
        //// TODO: 2016/12/1 没有消息的操作
    }

    public void setListener(chatDownPresenter listener){

        sendbtn.setOnClickListener(listener);
        morebtn.setOnClickListener(listener);
    }


    public String getMsg() {
        String contString = edit.getText().toString();
        return  contString;
    }

    @Override
    public String sendMsg() {
        adapter.notifyDataSetChanged();
        edit.setText("");
        return null;
    }


    @Override
    public void showmore() {
        //// TODO: 2016/12/2 显示聊天抽屉
        View chatview =View.inflate(context, R.layout.chat_drawer,this);
        drawer = new PopupWindow(chatview,600,LayoutParams.MATCH_PARENT,true);
        chatdown_lay.scrollTo(0, 600);
    }

    @Override
    public void hidemore() {
    }
}
