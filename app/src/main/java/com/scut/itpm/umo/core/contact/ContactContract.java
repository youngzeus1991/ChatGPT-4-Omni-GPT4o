package com.scut.itpm.umo.core.contact;

import com.scut.itpm.umo.BaseView;
import com.scut.itpm.umo.data.contact.ContactGroupModel;

import java.util.List;

/**
 * Created by DELL on 2016/11/2.
 */

public interface ContactContract {
    interface View extends BaseView{
        void showContactGroupModelList(List<ContactGroupModel>contactGroupModelList);
        void showNoContactGroupModelList();
    }
    interface Presenter{
        void fetchContactGroupModelList();
    }
}
