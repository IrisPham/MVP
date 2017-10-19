package com.example.visualstudio.demomvp.Presenter;

import com.example.visualstudio.demomvp.Model.Account;
import com.example.visualstudio.demomvp.Model.AccountHelper;
import com.example.visualstudio.demomvp.Model.Message;
import com.example.visualstudio.demomvp.View.LoginView;

/**
 * Created by Visual Studio on 10/14/2017.
 */

public class LoginPresenter implements LoginPresenterIm{
    private LoginView loginView;
    private AccountHelper accountHelper;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void checkLogin(String idAccount, String password) {
        if(!idAccount.equals("") && !password.equals("")){
            //Gửi yêu cầu đến server để xác thực tài khoản
             accountHelper = new AccountHelper(this);
            accountHelper.accAuth(idAccount,password);
        }
        if(idAccount.equals("")){loginView.onFail("Mã đăng nhập không được để trống");}
        if(password.equals("")){loginView.onFail("Mật khẩu không được để trống");}
    }

    @Override
    public void onAccAuthSuccess(String status, Message message) {
        loginView.onSuccess(status);
        loginView.dissmisProgressbar();
        loginView.navigateToHome();
    }

    @Override
    public void onAccAuthFail(String error) {
        loginView.onFail(error);
        loginView.dissmisProgressbar();
    }
}
