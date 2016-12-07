package com.scut.itpm.umo.core.Main.Main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.scut.itpm.umo.R;

import static android.support.v4.view.ViewPager.SCROLL_STATE_SETTLING;

/**
 * Created by DELL on 2016/11/5.
 */

public class MainView extends FrameLayout implements MainContract.View {

    private static final int PAGE_MESSAGE = 0;
    private static final int PAGE_CONTACT = 1;
    private static final int PAGE_ANNOUNCE = 2;
    private static final int PAGE_FOLLOW = 3;
    private static final int PAGE_INFORM = 4;

    private MainContract.Presenter mainViewPresenter;

    private MyViewPager viewPager;
    private RadioGroup radioGroup;

    private RadioButton messageTab;
    private RadioButton contactTab;
    private RadioButton announceTab;
    private RadioButton followTab;
    private RadioButton informTab;

    private void initView(Context context) {
        View view = inflate(context, R.layout.layout_main_view, this);

        viewPager = (MyViewPager) view.findViewById(R.id.id_main_view_pager);

        radioGroup = (RadioGroup) view.findViewById(R.id.id_main_radio_group_tab_bar);

        messageTab = (RadioButton) view.findViewById(R.id.id_main_radio_message);
        contactTab = (RadioButton) view.findViewById(R.id.id_main_radio_contract);
        announceTab = (RadioButton) view.findViewById(R.id.id_main_radio_announce);
        followTab = (RadioButton) view.findViewById(R.id.id_main_radio_follow);
        informTab = (RadioButton) view.findViewById(R.id.id_main_radio_inform);
    }

    public MainView(Context context) {
        super(context);
        initView(context);
    }

    public MainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void setListener(MainPresenter listener) {
        radioGroup.setOnCheckedChangeListener(listener);
        viewPager.addOnPageChangeListener(listener);
    }

    @Override
    public void informNavBarChangeTitle() {
        mainViewPresenter.informNavBarChangeTitle(getCurrTitle());
    }

    @Override
    public void onCheckChange(int i) {
        switch (i) {
            case R.id.id_main_radio_message:
                viewPager.setCurrentItem(PAGE_MESSAGE);
                break;
            case R.id.id_main_radio_contract:
                viewPager.setCurrentItem(PAGE_CONTACT);
                break;
            case R.id.id_main_radio_announce:
                viewPager.setCurrentItem(PAGE_ANNOUNCE);
                break;
            case R.id.id_main_radio_follow:
                viewPager.setCurrentItem(PAGE_FOLLOW);
                break;
            case R.id.id_main_radio_inform:
                viewPager.setCurrentItem(PAGE_INFORM);
                break;
        }
        informNavBarChangeTitle();

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        if (state == SCROLL_STATE_SETTLING) {
            switch (viewPager.getCurrentItem()) {
                case PAGE_MESSAGE:
                    messageTab.setChecked(true);
                    viewPager.setScrollable(true);
                    break;
                case PAGE_CONTACT:
                    contactTab.setChecked(true);
                    viewPager.setScrollable(true);
                    break;
                case PAGE_ANNOUNCE:
                    announceTab.setChecked(true);
                    viewPager.setScrollable(false);
                    break;
                case PAGE_FOLLOW:
                    followTab.setChecked(true);
                    viewPager.setScrollable(true);
                    break;
                case PAGE_INFORM:
                    informTab.setChecked(true);
                    viewPager.setScrollable(true);
                    break;
            }
        }
        informNavBarChangeTitle();
    }

    @Override
    public String getCurrTitle() {
        RadioButton radioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());
//        RadioButton radioButton=(RadioButton)radioGroup.getChildAt(i);
        return radioButton.getText().toString();
    }

    @Override
    public void setPresenter(Object presenter) {
        this.mainViewPresenter = (MainContract.Presenter) presenter;
    }

    @Override
    public void init() {
        defaultSetting();
    }


    private void defaultSetting() {
        //初始化
        viewPager.setCurrentItem(PAGE_ANNOUNCE);
        announceTab.setChecked(true);
        viewPager.setScrollable(false);

    }
}
