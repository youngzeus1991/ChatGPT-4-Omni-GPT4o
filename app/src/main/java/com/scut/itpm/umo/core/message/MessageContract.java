package com.scut.itpm.umo.core.message;

import com.scut.itpm.umo.BasePresenter;
import com.scut.itpm.umo.BaseView;

import java.util.List;
import java.util.Map;

/**
 * Created by DELL on 2016/11/2.
 */

public interface MessageContract {
    interface View extends BaseView {
        void showMessageList(List<Map<String, Object>> messageModelList);
        void showNOMessageList();

        void send_later();

    }
    interface Presenter extends BasePresenter {
        void fetchMessageList();

        void send_later();
    }
}
