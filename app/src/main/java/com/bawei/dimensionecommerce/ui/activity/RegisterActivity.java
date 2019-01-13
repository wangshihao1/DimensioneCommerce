package com.bawei.dimensionecommerce.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.bawei.dimensionecommerce.R;
import com.bawei.dimensionecommerce.data.bean.RegisterBean;
import com.bawei.dimensionecommerce.di.contract.IContractRegister;
import com.bawei.dimensionecommerce.di.presenter.IRegisterPresenterImp;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IContractRegister.IRegisterView {


    @BindView(R.id.login_phone)
    ImageButton loginPhone;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.activity_login_phone)
    EditText activityLoginPhone;
    @BindView(R.id.buju1)
    ConstraintLayout buju1;
    @BindView(R.id.register_phone)
    ImageButton registerPhone;
    @BindView(R.id.zhuce_group)
    RadioGroup zhuceGroup;
    @BindView(R.id.activity_register_phone)
    EditText activityRegisterPhone;
    @BindView(R.id.Sendverification)
    TextView Sendverification;
    @BindView(R.id.buju3)
    ConstraintLayout buju3;
    @BindView(R.id.login_pass)
    ImageButton loginPass;
    @BindView(R.id.pass_group)
    RadioGroup passGroup;
    @BindView(R.id.activity_register_password)
    EditText activityRegisterPassword;
    @BindView(R.id.Passwordswitching)
    ImageButton Passwordswitching;
    @BindView(R.id.buju2)
    ConstraintLayout buju2;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.register_Submit)
    Button registerSubmit;
    private IRegisterPresenterImp presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new IRegisterPresenterImp();
        presenter.attachView(this);

    }


    @Override
    public void showData(String responseData) {
        Gson gson = new Gson();
        RegisterBean registerBean = gson.fromJson(responseData,RegisterBean.class);
        if (registerBean.getStatus().equals("0000")) {
            Toast.makeText(this, "注册成功", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,LoginActivity.class));
        } else if (registerBean.getStatus().equals("1001")) {
            Toast.makeText(this, "该手机号已注册，不能重复注册！", Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView(this);
    }

    @OnClick({R.id.tv_register, R.id.register_Submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                break;
            case R.id.register_Submit:
                String phone = activityLoginPhone.getText().toString().trim();
                String pwd = activityRegisterPassword.getText().toString().trim();
                presenter.ruquestRegisterData(phone,pwd);
                break;
        }
    }


}
