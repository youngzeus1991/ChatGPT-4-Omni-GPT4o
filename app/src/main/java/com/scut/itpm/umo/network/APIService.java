package com.scut.itpm.umo.network;

import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by DELL on 2016/12/6.
 */

public interface APIService {
    //Request类型接口
    @GET("RequirementInCommunity")
    Call<List<RequirementModel>> getRequirementList(@Query("userID") int userID);

    @GET("FeelingInCommunity")
    Call<List<FeelingModel>> getFeelingList(@Query("userID") int userID);

    //Post类型接口
    @POST("CommendFeeling")
    Call<BaseResult> commendFeeling(@Query("userID") int userID,@Query("feelingID") int feelingID);

    @POST("CommentFeeling")
    Call<BaseResult> commentFeeling(@Query("userID") int userID,@Query("feelingID") int feelingID);

}
