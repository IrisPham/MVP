package com.example.visualstudio.demomvp.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.visualstudio.demomvp.Presenter.LoginPresenter;
import com.example.visualstudio.demomvp.View.LoginView;
import com.example.visualstudio.demomvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private TextView tvIdAccount;
    private TextView tvPassword;
    private Button btnLogin;
    private LinearLayout linearLayout;
    private ProgressBar prgAuthToken;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvIdAccount = (TextView) findViewById(R.id.textView_IdAccount);
        tvPassword = (TextView) findViewById(R.id.textView_Password);
        btnLogin = (Button) findViewById(R.id.Button_Login);
        btnLogin.setOnClickListener(this);
        linearLayout = (LinearLayout) findViewById(R.id.linearlayout);
        prgAuthToken = (ProgressBar) findViewById(R.id.progressBar_AuthToken);

    }

    @Override
    public void onSuccess(String status) {
        Toast.makeText(this, status, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressbar() {
        linearLayout.setVisibility(View.INVISIBLE);
        prgAuthToken.setVisibility(View.VISIBLE);
    }

    @Override
    public void dissmisProgressbar() {
        linearLayout.setVisibility(View.VISIBLE);
        prgAuthToken.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHome() {
        //Di chuyen den man hinh home
        //startActivity(new Intent(thiis,Home.class));
    }

    @Override
    public void onClick(View view) {
        loginPresenter = new LoginPresenter(this);
        loginPresenter.checkLogin(tvIdAccount.getText().toString(),tvPassword.getText().toString());
    }
}
