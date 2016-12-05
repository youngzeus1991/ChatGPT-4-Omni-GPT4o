package com.scut.itpm.umo.core.announce.sociaty.Requirement;

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
import android.widget.TextView;

import com.scut.itpm.umo.R;
import com.scut.itpm.umo.core.announce.sociaty.PhotoListAdapter;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/12/4.
 */

public class RequirementListAdapter implements ListAdapter {
    private Context mContext;
    private List<RequirementModel> requirementModelList =new ArrayList<>();
    private View.OnClickListener listener;
    public RequirementListAdapter(Context context, List<RequirementModel> requirementModelList, View.OnClickListener requirementView) {
        this.mContext=context;
        this.requirementModelList = requirementModelList;
        this.listener=requirementView;
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
        return requirementModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return requirementModelList.get(i);
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
        View requirementView= LayoutInflater.from(mContext).inflate(R.layout.item_requirement_model,null);
        ImageView requirementerPhotoImageView= (ImageView) requirementView.findViewById(R.id.id_requirement_requirementer_photo);
        TextView requirementerNameTextView= (TextView) requirementView.findViewById(R.id.id_requirement_requirementer_name);
        TextView requirementLocationTextView=(TextView)requirementView.findViewById(R.id.id_requirement_location);
        TextView requirementMomentTextView= (TextView) requirementView.findViewById(R.id.id_requirement_moment);
        TextView requirementContentTextView=(TextView)requirementView.findViewById(R.id.id_requirement_content);
        TextView requirementCommentCountTextView=(TextView )requirementView.findViewById(R.id.id_requirement_comment_count);
        TextView requirementCommendCountTextView=(TextView )requirementView.findViewById(R.id.id_requirement_commend_count);
        TextView requirementViewCountTextView=(TextView)requirementView.findViewById(R.id.id_requirement_view_count);
        GridView requirementPhotoList=(GridView)requirementView.findViewById(R.id.id_requirement_photo_list);

        Button bookButton=(Button)requirementView.findViewById(R.id.id_requirement_book_button);
        Button commendButton=(Button)requirementView.findViewById(R.id.id_requirement_commend_button);
        Button shareButton=(Button)requirementView.findViewById(R.id.id_requirement_share_button);



        bookButton.setOnClickListener(listener);
        commendButton.setOnClickListener(listener);
        shareButton.setOnClickListener(listener);

        RequirementModel requirementModel= requirementModelList.get(i);
        requirementerPhotoImageView.setImageBitmap(((BitmapDrawable)mContext.getResources().
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
            bitmapList.add(((BitmapDrawable)mContext.getResources().getDrawable((int)photoIDList.get(j))).getBitmap());
        }
        PhotoListAdapter adapter=new PhotoListAdapter(mContext,bitmapList);
        requirementPhotoList.setNumColumns(3);
        requirementPhotoList.setAdapter(adapter);

        return requirementView;
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
