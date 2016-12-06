package com.scut.itpm.umo.core.Main;

/**
 * Created by DELL on 2016/11/30.
 * 顶部导航栏与下方MainView的交互接口
 */


public interface Connector {
    /**
     *对MainView动作的监听
     * 导航栏标题变化
     */
    interface CallbackOnMainView {
        void navBarTitleShouldChange(String titleToBe);
    }

    /**
     *对导航栏动作的监听
     * 发布界面地图和社区-需求/心情的切换
     */
    interface CallbackOnNavBar {
        void mapFragmentShouldShow();
        void feelingFragmentShouldShow();
        void requirementFragmentShouldShow();

    }
}
