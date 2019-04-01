package com.example.interview;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api_Interface {

    @FormUrlEncoded
@POST("json.php")
Call<List<CountryClas>> getcountry(@Field("action") String action, @Field("umID") String umID
        , @Field("OauthToken") String OauthToken);



    @FormUrlEncoded
    @POST("json.php")
    Call<List<StatesClas>> getState(@Field("action") String action, @Field("umID") String umID
                                    ,@Field("Country_Id") String Country_Id
            , @Field("OauthToken") String OauthToken);

    @FormUrlEncoded
    @POST("json.php")
    Call<List<CityClas>> getCity(@Field("action") String action, @Field("umID") String umID
            ,@Field("State_Id") String State_Id
            , @Field("OauthToken") String OauthToken);

}
