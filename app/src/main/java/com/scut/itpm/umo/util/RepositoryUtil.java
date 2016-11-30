package com.scut.itpm.umo.util;

import android.content.Context;

import com.scut.itpm.umo.data.announce.AnnounceRepository;
import com.scut.itpm.umo.data.announce.local.AnnounceLocalDataSource;
import com.scut.itpm.umo.data.announce.remote.AnnounceRemoteDataSource;

/**
 * Created by DELL on 2016/11/30.
 */

public class RepositoryUtil {
    //TODO 这里由一个工具类对Repository进行统一管理
    public static AnnounceRepository getAnnounceRepository(Context context){
        return AnnounceRepository.getInstance(context, AnnounceLocalDataSource.getInstance(context), AnnounceRemoteDataSource.getInstance(context));
    }

}
