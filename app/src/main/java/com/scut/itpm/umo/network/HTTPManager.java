package com.scut.itpm.umo.network;

import com.scut.itpm.umo.data.announce.AnnounceDataSource;
import com.scut.itpm.umo.data.announce.FeelingModel;
import com.scut.itpm.umo.data.announce.RequirementModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL on 2016/12/6.
 */

public class HTTPManager {
    private static HTTPManager INSTANCE;
    private APIService apiService;

    private HTTPManager() {
        Retrofit retrofit=new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(getServerIP())
                .build();
        this.apiService=retrofit.create(APIService.class);
    }
    public static HTTPManager getInstance(){
        if (INSTANCE!=null){
            return INSTANCE;
        }
        return INSTANCE=new HTTPManager();
    }
    public void httpGetRequirementList(final AnnounceDataSource.GetRequirementListCallback callback){
        Call<List<RequirementModel>> call=apiService.getRequirementList();
        call.enqueue(new Callback<List<RequirementModel>>() {
            @Override
            public void onResponse(Call<List<RequirementModel>> call, Response<List<RequirementModel>> response) {
                callback.didGetRequirementList(response.body());
            }

            @Override
            public void onFailure(Call<List<RequirementModel>> call, Throwable t) {
                callback.requirementListNotAvailable();
            }
        });
    }
    public void httpGetFeelingList(final AnnounceDataSource.GetFeelingListCallback callback){
        Call<List<FeelingModel>> call=apiService.getFeelingList();
        call.enqueue(new Callback<List<FeelingModel>>() {
            @Override
            public void onResponse(Call<List<FeelingModel>> call, Response<List<FeelingModel>> response) {
                callback.didGetFeelingList(response.body());
            }

            @Override
            public void onFailure(Call<List<FeelingModel>> call, Throwable t) {
                callback.feelingListNotAvailable();
            }
        });
    }
    private String getServerIP(){
        return ("http://"+"192.168.1.1");
    }
}
