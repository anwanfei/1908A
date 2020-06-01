package com.anfly.mvptest;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anfly.mvptest.base.BaseActivity;
import com.anfly.mvptest.base.BaseView;
import com.anfly.mvptest.bean.LoginBean;
import com.anfly.mvptest.model.LoginModel;
import com.anfly.mvptest.presenter.LoginPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity<LoginPresenter, BaseView<LoginBean>> implements BaseView<LoginBean> {

    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected BaseView<LoginBean> initMvpView() {
        return this;
    }

    @Override
    protected LoginPresenter initPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String name = etName.getText().toString().trim();
        String pwd = etPwd.getText().toString().trim();
        mPresenter.login(name, pwd);
    }

    @Override
    public void onSucess(LoginBean loginBean) {
        Toast.makeText(MainActivity.this, "登錄成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
