package com.scut.itpm.umo.core.Main.Main;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by DELL on 2016/12/7.
 */

public class MyViewPager extends ViewPager {
    private boolean isScrollable;
    public MyViewPager(Context context) {
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setScrollable(boolean scrollable) {
        isScrollable = scrollable;
    }

    @Override
    public boolean onFilterTouchEventForSecurity(MotionEvent event) {
        return super.onFilterTouchEventForSecurity(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if(!isScrollable){
            return false;
        }
        return super.onTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if(!isScrollable){
            return false;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
