package com.behnamnasehi.supportconnection.network;

import com.behnamnasehi.supportconnection.model.HandShake;
import com.behnamnasehi.supportconnection.utilitis.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET(Constant.BASE_URL)
    Call<HandShake> requestMainResponse(@Query("room_id") String room_id, @Query("pageNo") String pageNo, @Query("limit") String limit);

}
