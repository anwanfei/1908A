package com.anfly.mvp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.anfly.mvp.base.BaseActivity;
import com.anfly.mvp.bean.LoginBean;
import com.anfly.mvp.presenter.ImpLoginPresenter;
import com.anfly.mvp.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<ImpLoginPresenter, LoginView> implements LoginView {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected LoginView initMvpView() {
        return this;
    }

    @Override
    protected ImpLoginPresenter initMvpPresenter() {
        return new ImpLoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String pwd = etPwd.getText().toString().trim();
        String name = etName.getText().toString().trim();
        mPresenter.login(name, pwd);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
