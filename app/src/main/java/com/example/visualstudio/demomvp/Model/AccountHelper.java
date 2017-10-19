package com.example.visualstudio.demomvp.Model;

import android.util.Log;

import com.example.visualstudio.demomvp.Api.ApiClient;
import com.example.visualstudio.demomvp.Api.ApiInterface;
import com.example.visualstudio.demomvp.Presenter.LoginPresenterIm;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public class AccountHelper implements OnLoadAccountResult {
    private LoginPresenterIm loginPresenterIm;

    public AccountHelper(LoginPresenterIm loginPresenterIm) {
        this.loginPresenterIm = loginPresenterIm;
    }

    public void accAuth(String idAccount, String password) {
        final ApiInterface apiInterface = ApiClient.accAuth().create(ApiInterface.class);
        Call<Message> call = apiInterface.accAuth(idAccount, password);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                //Kiem tra su hoan thien cua goi tin
                if (response.isSuccessful()) {
                    Message message = response.body();
                    if (message.getMessage() == 1) {
                        authTokenSuccess("Dang nhap thanh cong", message);
                    } else {
                       authTokenFail("Dang nhap that bai - Tai khoan khong dung");
                    }
                }
            }
            @Override
            public void onFailure(Call<Message> call, Throwable t) {
                authTokenFail("Loi ket noi den Server");
            }
        });
    }

    @Override
    public void authTokenSuccess(String status, Message message) {
        loginPresenterIm.onAccAuthSuccess(status, message);
    }

    @Override
    public void authTokenFail(String error) {
        loginPresenterIm.onAccAuthFail(error);
    }
}
