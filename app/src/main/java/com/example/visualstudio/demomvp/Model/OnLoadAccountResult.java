package com.example.visualstudio.demomvp.Model;

/**
 * Created by Visual Studio on 10/7/2017.
 */

public interface OnLoadAccountResult {
    void authTokenSuccess(String status,Message message);
    void authTokenFail(String error);
}
