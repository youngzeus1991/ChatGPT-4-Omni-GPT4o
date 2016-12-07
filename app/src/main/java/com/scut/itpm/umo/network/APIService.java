package com.scut.itpm.umo.network;

import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by DELL on 2016/12/6.
 */

public interface APIService {
    @GET("RequirementInCommunity")
    Call<List<RequirementModel>> getRequirementList();

    @GET("FeelingInCommunity")
    Call<List<FeelingModel>> getFeelingList();
}
