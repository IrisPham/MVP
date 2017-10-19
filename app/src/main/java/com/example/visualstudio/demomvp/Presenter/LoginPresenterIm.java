package com.example.visualstudio.demomvp.Presenter;

import com.example.visualstudio.demomvp.Model.Account;
import com.example.visualstudio.demomvp.Model.Message;

/**
 * Created by Visual Studio on 10/14/2017.
 */

public interface LoginPresenterIm {
    void checkLogin(String idAccount, String password);
    void onAccAuthSuccess(String status, Message message);
    void onAccAuthFail(String error);
}
