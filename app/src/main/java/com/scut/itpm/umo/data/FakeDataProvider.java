package com.scut.itpm.umo.data;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by DELL on 2016/11/30.
 */

public class FakeDataProvider {
    //TODO 获取假数据的地方
    public static List<FeelingModel> getFeelingList() {
        List<FeelingModel> feelingModelList = new ArrayList<>();

        FeelingModel fake1 = new FeelingModel();
        fake1.setFeelingerName("李杭澍");
        fake1.setFeelingerPhotoID(R.drawable.fake_data_announce_1);
        fake1.setFeelingID(1);
        fake1.setFeelingContent("我最近好寂寞啊，希望有个帅哥来炸窝聊天啊~~啊啊啊啊啊啊啊啊啊啊~啊啊");
        fake1.setCommentCount(25);
        fake1.setCommendCount(52);
        Date currDate1 = new Date(System.currentTimeMillis()-111111);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        fake1.setFeelingMoment(formatter.format(currDate1));
        fake1.setViewCount(1240);
        fake1.setFeelingLocation("华南理工大学");
        List imageList=new ArrayList();
        imageList.add(R.drawable.action_commend);
        imageList.add(R.drawable.action_comment);
        imageList.add(R.drawable.action_view);
        imageList.add(R.drawable.fake_data_announce_2);
        imageList.add(R.drawable.fake_data_announce_3);
        imageList.add(R.drawable.fake_data_announce_4);
        imageList.add(R.drawable.main_tab_bar_contacts);
        imageList.add(R.drawable.main_tab_bar_announce);
        imageList.add(R.drawable.main_tab_bar_follow);
        imageList.add(R.drawable.main_tab_bar_inform);
        fake1.setFeelingImageList(imageList);

        FeelingModel fake2 = new FeelingModel();
        fake2.setFeelingerName("梁耀友");
        fake2.setFeelingerPhotoID(R.drawable.fake_data_announce_2);
        fake2.setFeelingID(2);
        fake2.setFeelingContent("我最近在玩Umo，一起来玩吧~");
        fake2.setCommentCount(1);
        fake2.setCommendCount(2);
        Date currDate2 = new Date(System.currentTimeMillis() - 222222);
        fake2.setFeelingMoment(formatter.format(currDate2));
        fake2.setViewCount(1143);
        fake2.setFeelingLocation("C10-652");
        fake2.setFeelingImageList(imageList);

        FeelingModel fake3 = new FeelingModel();
        fake3.setFeelingerName("张小贤");
        fake3.setFeelingerPhotoID(R.drawable.fake_data_announce_3);
        fake3.setFeelingID(3);
        fake3.setFeelingContent("二饭篮球场来个基友一起战斗~");
        fake3.setCommentCount(35);
        fake3.setCommendCount(67);
        Date currDate3 = new Date(System.currentTimeMillis() - 333333);
        fake3.setFeelingMoment(formatter.format(currDate3));
        fake3.setViewCount(1240);
        fake3.setFeelingLocation("华南理工大学-二饭篮球场");
        fake3.setFeelingImageList(imageList);

        FeelingModel fake4 = new FeelingModel();
        fake4.setFeelingerName("张志斌");
        fake4.setFeelingerPhotoID(R.drawable.fake_data_announce_4);
        fake4.setFeelingID(4);
        fake4.setFeelingContent("峡谷见，左小龙，有大龙，上先锋，下蓝爸~");
        fake4.setCommentCount(86);
        fake4.setCommendCount(143);
        Date currDate4 = new Date(System.currentTimeMillis() - 444444);
        fake4.setFeelingMoment(formatter.format(currDate4));
        fake4.setViewCount(1240);
        fake4.setFeelingLocation("华南理工大学-召唤师峡谷");
        fake4.setFeelingImageList(imageList);

        feelingModelList.add(fake1);
        feelingModelList.add(fake2);
        feelingModelList.add(fake3);
        feelingModelList.add(fake4);

        return feelingModelList;
    }
    public static List<RequirementModel> getRequirementList() {
        List<RequirementModel> requirementModelList = new ArrayList<>();

        RequirementModel fake1 = new RequirementModel();
        fake1.setRequirementerName("李杭澍");
        fake1.setRequirementerPhotoID(R.drawable.fake_data_announce_1);
        fake1.setRequirementID(1);
        fake1.setRequirementContent("我最近好寂寞啊，希望有个帅哥来炸窝聊天啊~~啊啊啊啊啊啊啊啊啊啊~啊啊");
        fake1.setCommentCount(25);
        fake1.setBookCount(52);
        Date currDate1 = new Date(System.currentTimeMillis() - 1111);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:SS");
        fake1.setRequirementMoment(formatter.format(currDate1));
        fake1.setViewCount(145);
        fake1.setRequirementLocation("华南理工大学");
        List imageList=new ArrayList();
        imageList.add(R.drawable.action_commend);
        imageList.add(R.drawable.action_comment);
        imageList.add(R.drawable.action_view);
        imageList.add(R.drawable.fake_data_announce_2);
        imageList.add(R.drawable.fake_data_announce_3);
        imageList.add(R.drawable.fake_data_announce_4);
        imageList.add(R.drawable.main_tab_bar_contacts);
        imageList.add(R.drawable.main_tab_bar_announce);
        imageList.add(R.drawable.main_tab_bar_follow);
        imageList.add(R.drawable.main_tab_bar_inform);
        fake1.setRequirementImageList(imageList);

        RequirementModel fake2 = new RequirementModel();
        fake2.setRequirementerName("梁耀友");
        fake2.setRequirementerPhotoID(R.drawable.fake_data_announce_2);
        fake2.setRequirementID(2);
        fake2.setRequirementContent("我最近在玩Umo，一起来玩吧~");
        fake2.setCommentCount(1);
        fake2.setBookCount(2);
        Date currDate2 = new Date(System.currentTimeMillis() - 2222);
        fake2.setRequirementMoment(formatter.format(currDate2));
        fake2.setViewCount(682);
        fake2.setRequirementLocation("C10-652");
        fake2.setRequirementImageList(imageList);

        RequirementModel fake3 = new RequirementModel();
        fake3.setRequirementerName("张小贤");
        fake3.setRequirementerPhotoID(R.drawable.fake_data_announce_3);
        fake3.setRequirementID(1);
        fake3.setRequirementContent("二饭篮球场来个基友一起战斗~");
        fake3.setCommentCount(35);
        fake3.setBookCount(67);
        Date currDate3 = new Date(System.currentTimeMillis() - 3333);
        fake3.setRequirementMoment(formatter.format(currDate3));
        fake3.setViewCount(1030);
        fake3.setRequirementLocation("华南理工大学-二饭篮球场");
        fake3.setRequirementImageList(imageList);

        RequirementModel fake4 = new RequirementModel();
        fake4.setRequirementerName("张志斌");
        fake4.setRequirementerPhotoID(R.drawable.fake_data_announce_4);
        fake4.setRequirementID(1);
        fake4.setRequirementContent("峡谷见，左小龙，有大龙，上先锋，下蓝爸~");
        fake4.setCommentCount(86);
        fake4.setBookCount(143);
        Date currDate4 = new Date(System.currentTimeMillis() - 4444);
        fake4.setRequirementMoment(formatter.format(currDate4));
        fake4.setViewCount(1240);
        fake4.setRequirementLocation("华南理工大学-召唤师峡谷");
        fake4.setRequirementImageList(imageList);

        requirementModelList.add(fake4);
        requirementModelList.add(fake1);
        requirementModelList.add(fake3);
        requirementModelList.add(fake2);

        return requirementModelList;
    }
}
