package com.example.visualstudio.demomvp.Api;

import com.example.visualstudio.demomvp.Model.Message;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Visual Studio on 10/14/2017.
 */
public interface ApiInterface {
    @POST("AccountAuthenticator.php")
    @FormUrlEncoded
    Call<Message> accAuth(@Field("idAccount") String idAccount,
                            @Field("password") String password);

}