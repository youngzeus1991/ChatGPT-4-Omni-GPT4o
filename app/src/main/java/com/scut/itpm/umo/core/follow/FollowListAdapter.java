package com.scut.itpm.umo.core.follow;

import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.announce.sociaty.PhotoListAdapter;
import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;
import com.scut.itpm.umo.data.follow.FollowModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/12/4.
 */

public class FollowListAdapter implements ListAdapter {
    private Context mContext;
    private List<FollowModel> followModelList=new ArrayList<>();
    private View.OnClickListener listener;
    public FollowListAdapter(Context context, List<FollowModel> followModelList, View.OnClickListener followView) {
        this.mContext=context;
        this.followModelList=followModelList;
        this.listener=followView;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int i) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {

    }

    @Override
    public int getCount() {
        return followModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return followModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
       FollowModel followModel=followModelList.get(i);
        if(followModel instanceof FeelingModel){
            return initFeelingView(mContext,(FeelingModel)followModel);
        }
        if(followModel instanceof RequirementModel){
            return initRequirementView(mContext,(RequirementModel)followModel);
        }

        //此处缺少类型检查

     return null ;


    }

    private View initRequirementView(Context context, RequirementModel requirementModel) {
        View requirementView= LayoutInflater.from(context).inflate(R.layout.item_requirement_model,null);
        ImageView requirementerPhotoImageView= (ImageView) requirementView.findViewById(R.id.id_requirement_requirementer_photo);
        TextView requirementerNameTextView= (TextView) requirementView.findViewById(R.id.id_requirement_requirementer_name);
        TextView requirementLocationTextView=(TextView)requirementView.findViewById(R.id.id_requirement_location);
        TextView requirementMomentTextView= (TextView) requirementView.findViewById(R.id.id_requirement_moment);
        TextView requirementContentTextView=(TextView)requirementView.findViewById(R.id.id_requirement_content);
        TextView requirementCommentCountTextView=(TextView )requirementView.findViewById(R.id.id_requirement_comment_count);
        TextView requirementCommendCountTextView=(TextView )requirementView.findViewById(R.id.id_requirement_commend_count);
        TextView requirementViewCountTextView=(TextView)requirementView.findViewById(R.id.id_requirement_view_count);
        GridView requirementPhotoList=(GridView)requirementView.findViewById(R.id.id_requirement_photo_list);

        RelativeLayout relativeLayout=(RelativeLayout)requirementView.findViewById(R.id.id_requirement_info_rl);
        TextView actionName=new TextView(context);
        actionName.setText("发布了需求");
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(100,100);
        layoutParams.height= RelativeLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.width= RelativeLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.addRule(RelativeLayout.RIGHT_OF,R.id.id_requirement_requirementer_name);
        layoutParams.leftMargin=10;
        relativeLayout.addView(actionName,layoutParams);

        Button bookButton=(Button)requirementView.findViewById(R.id.id_requirement_book_button);
        Button commendButton=(Button)requirementView.findViewById(R.id.id_requirement_commend_button);
        Button shareButton=(Button)requirementView.findViewById(R.id.id_requirement_share_button);

        bookButton.setOnClickListener(listener);
        commendButton.setOnClickListener(listener);
        shareButton.setOnClickListener(listener);

        requirementerPhotoImageView.setImageBitmap(((BitmapDrawable)context.getResources().
                getDrawable(requirementModel.getRequirementerPhotoID())).getBitmap());
        requirementerNameTextView.setText(requirementModel.getRequirementerName());
        requirementLocationTextView.setText(requirementModel.getRequirementLocation());
        requirementMomentTextView.setText(requirementModel.getRequirementMoment());
        requirementContentTextView.setText(requirementModel.getRequirementContent());
        requirementCommentCountTextView.setText(requirementModel.getCommentCount()+"");
        requirementCommendCountTextView.setText(requirementModel.getBookCount()+"");
        requirementViewCountTextView.setText(requirementModel.getViewCount()+"");

        List photoIDList=requirementModel.getRequirementImageList();
        List<Bitmap> bitmapList=new ArrayList<>();
        for(int j=0;j<photoIDList.size();j++){
            bitmapList.add(((BitmapDrawable)context.getResources().getDrawable((int)photoIDList.get(j))).getBitmap());
        }
        PhotoListAdapter adapter=new PhotoListAdapter(context,bitmapList);
        requirementPhotoList.setNumColumns(3);
        requirementPhotoList.setAdapter(adapter);

        return requirementView;

    }

    private View initFeelingView(Context context,FeelingModel feelingModel){
        View feelingView= LayoutInflater.from(mContext).inflate(R.layout.item_feeling_model,null);
        ImageView feelingerPhotoImageView= (ImageView) feelingView.findViewById(R.id.id_feeling_feelinger_photo);
        TextView feelingerNameTextView= (TextView) feelingView.findViewById(R.id.id_feeling_feelinger_name);
        TextView feelingLocationTextView=(TextView)feelingView.findViewById(R.id.id_feeling_location);
        TextView feelingMomentTextView= (TextView) feelingView.findViewById(R.id.id_feeling_moment);
        TextView feelingContentTextView=(TextView)feelingView.findViewById(R.id.id_feeling_content);
        TextView feelingCommentCountTextView=(TextView )feelingView.findViewById(R.id.id_feeling_comment_count);
        TextView feelingCommendCountTextView=(TextView )feelingView.findViewById(R.id.id_feeling_commend_count);
        TextView feelingViewCountTextView=(TextView)feelingView.findViewById(R.id.id_feeling_view_count);
        GridView feelingPhotoList=(GridView)feelingView.findViewById(R.id.id_feeling_photo_list);

        //动态增加控件，表示关注者动作
        RelativeLayout relativeLayout=(RelativeLayout)feelingView.findViewById(R.id.id_feeling_info_rl);
        TextView actionName=new TextView(context);
        actionName.setText("发布了心情");
        RelativeLayout.LayoutParams layoutParams=new RelativeLayout.LayoutParams(100,100);
        layoutParams.height= RelativeLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.width= RelativeLayout.LayoutParams.WRAP_CONTENT;
        layoutParams.addRule(RelativeLayout.RIGHT_OF,R.id.id_feeling_feelinger_name);
        layoutParams.leftMargin=10;
        relativeLayout.addView(actionName,layoutParams);

        Button commentButton=(Button)feelingView.findViewById(R.id.id_feeling_comment_button);
        Button commendButton=(Button)feelingView.findViewById(R.id.id_feeling_commend_button);
        Button shareButton=(Button)feelingView.findViewById(R.id.id_feeling_share_button);

        feelingerPhotoImageView.setOnClickListener(listener);
        feelingerNameTextView.setOnClickListener(listener);
        commentButton.setOnClickListener(listener);
        commendButton.setOnClickListener(listener);
        shareButton.setOnClickListener(listener);

//        feelingPhotoList.setClickable(false);
//        feelingPhotoList.setPressed(false);
//        feelingPhotoList.setEnabled(false);

//        feelingPhotoList.setOnItemClickListener((AdapterView.OnItemClickListener) listener);

        feelingerPhotoImageView.setImageBitmap(((BitmapDrawable)mContext.getResources().
                getDrawable(feelingModel.getFeelingerPhoto())).getBitmap());
        feelingerNameTextView.setText(feelingModel.getFeelingerName());
        feelingLocationTextView.setText(feelingModel.getFeelingLocation());
        feelingMomentTextView.setText(feelingModel.getFeelingMoment());
        feelingContentTextView.setText(feelingModel.getFeelingContent());
        feelingCommentCountTextView.setText(feelingModel.getCommentCount()+"");
        feelingCommendCountTextView.setText(feelingModel.getCommendCount()+"");
        feelingViewCountTextView.setText(feelingModel.getViewCount()+"");

        List photoIDList=feelingModel.getFeelingImageList();
        List<Bitmap> bitmapList=new ArrayList<>();
        for(int j=0;j<photoIDList.size();j++){
            bitmapList.add(((BitmapDrawable)mContext.getResources().getDrawable((int)photoIDList.get(j))).getBitmap());
        }
        PhotoListAdapter adapter=new PhotoListAdapter(mContext,bitmapList);
        feelingPhotoList.setNumColumns(3);
        feelingPhotoList.setAdapter(adapter);

        return feelingView;
    }
    @Override
    public int getItemViewType(int i) {
        return 1;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
