package com.scut.itpm.umo.core.Main.NavBar;

import android.content.Context;
import android.graphics.drawable.PaintDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scut.itpm.umo.R;

/**
 * Created by DELL on 2016/11/2.
 */

public class NavBarView extends RelativeLayout implements NavBarContract.View {

    private NavBarPresenter presenter;

    private Button settingBtn;
    private TextView title;
    private LinearLayout announceTitleLL;
    private Button searchBtn;

    private TextView mapTitle;
    private TextView sociatyTitle;
    private TextView requirementTitle;
    private TextView feelingTitle;

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
        announceTitleLL = (LinearLayout) view.findViewById(R.id.id_nav_bar_announce_title);

        mapTitle= (TextView) view.findViewById(R.id.id_nav_bar_map);
        sociatyTitle=(TextView) view.findViewById(R.id.id_nav_bar_sociaty);

        mapTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.informMapFragmentShouldShow();
            }
        });
        sociatyTitle.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                View choiceSwitchView= LayoutInflater.from(getContext()).inflate(R.layout.layout_popup_switch,null);
                final PopupWindow popupWindow=new PopupWindow(choiceSwitchView,200,200);
                feelingTitle= (TextView) choiceSwitchView.findViewById(R.id.id_switch_feeling);
                requirementTitle= (TextView) choiceSwitchView.findViewById(R.id.id_switch_requirement);

                feelingTitle.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.informFeelingFragmentShouldShow();
                        popupWindow.dismiss();
                    }
                });
                requirementTitle.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        presenter.informRequirementFragmentShouldShow();
                        popupWindow.dismiss();
                    }
                });
                popupWindow.setFocusable(true);
                popupWindow.setBackgroundDrawable(new PaintDrawable());
                popupWindow.showAsDropDown(sociatyTitle);
            }
        });

    }


    @Override
    public void setPresenter(Object presenter) {
        this.presenter = (NavBarPresenter) presenter;
    }

    @Override
    public void setCurrentTitle(String titleTobe) {
        if (!titleTobe.equals(getResources().getString(R.string.announce))) {
            announceTitleLL.setVisibility(INVISIBLE);
            title.setVisibility(VISIBLE);
            title.setText(titleTobe);

        } else {
            title.setVisibility(INVISIBLE);
            announceTitleLL.setVisibility(VISIBLE);
        }
    }
}
