package com.mvptest.mvp_demo.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.mvptest.mvp_demo.R;

public class LoginActivity extends AppCompatActivity implements LoginBaseInterface.LoginViewInterface, View.OnClickListener {

    private ProgressBar mLoginPb;
    /**
     * 手机号
     */
    private EditText mUserMobileEt;
    /**
     * 密码
     */
    private EditText mUserPwdEt;
    /**
     * 登 录
     */
    private TextView mLoginConfirmTv;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        LoginModel loginModel = new LoginModel();
        loginPresenter = new LoginPresenter(loginModel,this);

    }

    @Override
    public void showRequestNetDialog() {
        if (!mLoginPb.isShown()) {
            mLoginPb.setVisibility(View.VISIBLE); 
        }
       
    }

    @Override
    public void cancelRequestNetDialog() {
        if (mLoginPb.isShown()) {
            mLoginPb.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void LoginSuccess(Object o) {
        if (mLoginPb.isShown()) {
            mLoginPb.setVisibility(View.INVISIBLE);
        }
        Toast.makeText(getApplicationContext(), (String)o, Toast.LENGTH_LONG).show();
    }


    @Override
    public void LoginUnSuccess() {
        if (mLoginPb.isShown()) {
            mLoginPb.setVisibility(View.INVISIBLE);
        }
        Toast.makeText(getApplicationContext(), "登录失败", Toast.LENGTH_LONG).show();
    }

    private void initView() {
        mLoginPb = (ProgressBar) findViewById(R.id.login_pb);
        mUserMobileEt = (EditText) findViewById(R.id.user_mobile_et);
        mUserPwdEt = (EditText) findViewById(R.id.user_pwd_et);
        mLoginConfirmTv = (TextView) findViewById(R.id.login_confirm_tv);
        mLoginConfirmTv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.login_confirm_tv:
                loginPresenter.requestToLogin(new LoginBean(mUserMobileEt.getText().toString().trim(),mUserPwdEt.getText().toString().trim()));
                break;
        }
    }
}
