package com.scut.itpm.umo.core.inform;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.scut.itpm.umo.BaseView;

/**
 * Created by DELL on 2016/11/2.
 */

public interface InformContract {
    interface View extends BaseView {
        void showInformList();
        void setInformListView();
        ListView getInformListView();
        Context getInformContext();
        InformDetail getInformDetail();
    }
    interface Presenter{
        void onStart();
    }
}
