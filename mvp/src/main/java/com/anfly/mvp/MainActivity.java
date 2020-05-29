package com.anfly.mvp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.anfly.mvp.bean.LoginBean;
import com.anfly.mvp.presenter.ImpLoginPresenter;
import com.anfly.mvp.view.LoginView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText et_name;
    private EditText et_pwd;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                loign();
                break;
        }
    }

    private void loign() {
        String name = et_name.getText().toString().trim();
        String pwd = et_pwd.getText().toString().trim();
        ImpLoginPresenter presenter = new ImpLoginPresenter(this);
        presenter.login(name, pwd);
    }

    @Override
    public void onSuccess(LoginBean loginBean) {
        Toast.makeText(MainActivity.this, "登錄成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFail(String error) {
        Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
    }
}
