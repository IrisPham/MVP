package com.example.visualstudio.demomvp.View;

/**
 * Created by Visual Studio on 10/14/2017.
 */

public interface LoginView {
    void onSuccess(String status);
    void onFail(String error);
    void showProgressbar();
    void dissmisProgressbar();
    void navigateToHome();
}
