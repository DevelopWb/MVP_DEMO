package com.mvptest.mvp_demo.login;

/**
 * Author:wang_sir
 * Time:2018/5/7 20:38
 * Description:This is LoginBaseInterface
 */
public class LoginBaseInterface {

    public interface LoginPresenterInterface<T>{

        void requestToLogin(T t);
    }

    public interface LoginViewInterface<T>{

        void showRequestNetDialog();//展示请求网络的dialog
        void cancelRequestNetDialog();//finish掉dialog

        void LoginSuccess(T t);//登录成功
        void LoginUnSuccess();//登录不成功
    }

}
