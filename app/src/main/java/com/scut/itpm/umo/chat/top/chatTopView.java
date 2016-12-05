package com.scut.itpm.umo.chat.top;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scut.itpm.umo.R;

/**
 * Created by yaoyou on 2016/11/30.
 */

public class chatTopView extends RelativeLayout implements chatTopContract.View{
    private chatTopContract.Presenter presenter;

    private Button backbtn;
    private Button userbtn;
    private TextView user_name;

    public chatTopView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public chatTopView(Context context) {
        super(context);
        initView(context);
    }

    public chatTopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.layout_chattop, this);
        backbtn = (Button) view.findViewById(R.id.id_chat_back);
        userbtn = (Button) view.findViewById(R.id.id_chat_user);
        user_name = (TextView) view.findViewById(R.id.username);

    }

    public void setListener(chatTopPresenter listener){
        backbtn.setOnClickListener(listener);
    }

    @Override
    public void setUserName(String name) {
        user_name.setText(name);
    }

    @Override
    public void setPresenter(Object presenter) {
        this.presenter=(chatTopPresenter)presenter;
    }
}
