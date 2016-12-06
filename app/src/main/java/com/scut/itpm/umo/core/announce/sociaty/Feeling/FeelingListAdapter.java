package com.scut.itpm.umo.core.announce.sociaty.Feeling;

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
import com.scut.itpm.umo.data.announce.FeelingModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 2016/12/4.
 */

public class FeelingListAdapter implements ListAdapter {
    private Context mContext;
    private List<FeelingModel> feelingModelList=new ArrayList<>();
    private View.OnClickListener listener;
    public FeelingListAdapter(Context context, List<FeelingModel> feelingModelList,View.OnClickListener feelingView) {
        this.mContext=context;
        this.feelingModelList=feelingModelList;
        this.listener=feelingView;
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
        return feelingModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return feelingModelList.get(i);
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

        FeelingModel feelingModel=feelingModelList.get(i);
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
