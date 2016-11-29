package com.scut.itpm.umo.core.Main.Nav;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scut.itpm.umo.R;

/**
 * Created by DELL on 2016/11/2.
 */

public class NavBarView extends RelativeLayout implements NavBarContract.View {

    private NavBarController presenter;

    private Button settingBtn;
    public TextView title;
    private Button searchBtn;

    public NavBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public NavBarView(Context context) {
        super(context);
        initView(context);
    }

    public NavBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View view = View.inflate(context, R.layout.layout_nav_bar_view, this);
        settingBtn = (Button) view.findViewById(R.id.id_nav_bar_setting);
        title = (TextView) view.findViewById(R.id.id_nav_bar_title);
        searchBtn = (Button) view.findViewById(R.id.id_nav_bar_search);

    }


    @Override
    public void setPresenter(Object presenter) {
        this.presenter=(NavBarController)presenter;
    }

    @Override
    public void setCurrentTitle(String titleTobe) {
        title.setText(titleTobe);
    }
}
