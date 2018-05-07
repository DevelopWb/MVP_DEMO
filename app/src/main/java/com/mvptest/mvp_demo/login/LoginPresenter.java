package com.mvptest.mvp_demo.login;

import com.mvptest.mvp_demo.netWork.NetTask;
import com.mvptest.mvp_demo.netWork.RequestStatus;

/**
 * Author:wang_sir
 * Time:2018/5/7 20:48
 * Description:This is LoginPresenter
 * LoginPresenter 实现约定接口中的presenter接口和请求网络状态的接口
 */
public class LoginPresenter implements LoginBaseInterface.LoginPresenterInterface<LoginBean>,RequestStatus<String> {


    private NetTask<LoginBean> netTask;
    private LoginBaseInterface.LoginViewInterface viewInterface;

    public LoginPresenter(NetTask<LoginBean> netTask, LoginBaseInterface.LoginViewInterface viewInterface) {
        this.netTask = netTask;
        this.viewInterface = viewInterface;
    }

    @Override
    public void requestToLogin(LoginBean loginBean) {
        netTask.exec(loginBean,this);
    }

    @Override
    public void onStart() {
        viewInterface.showRequestNetDialog();
    }

    @Override
    public void onSuccess(String str) {
        viewInterface.cancelRequestNetDialog();
        viewInterface.LoginSuccess(str);
    }

    @Override
    public void onError() {
        viewInterface.cancelRequestNetDialog();
        viewInterface.LoginUnSuccess();
    }
}
