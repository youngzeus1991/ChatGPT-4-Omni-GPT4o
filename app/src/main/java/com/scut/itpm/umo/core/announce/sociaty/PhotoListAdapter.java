package com.scut.itpm.umo.core.announce.sociaty;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.scut.itpm.umo.R;

import java.util.List;

/**
 * Created by DELL on 2016/12/5.
 */

public class PhotoListAdapter extends BaseAdapter {
    private List<Bitmap> photoList;
    private Context context;
    public PhotoListAdapter(Context context,List<Bitmap> photoList) {
        this.photoList=photoList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return photoList.size();
    }

    @Override
    public Object getItem(int i) {
        return photoList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View photoView= LayoutInflater.from(context).inflate(R.layout.item__photo,null);
        ImageView photoImageView=(ImageView)photoView.findViewById(R.id.id_item_photo);
        photoImageView.setImageBitmap(photoList.get(i));
        return photoView;
    }
}
