package com.bawei.dimensionecommerce.ui.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dimensionecommerce.R;
import com.bawei.dimensionecommerce.data.bean.RegisterBean;
import com.bawei.dimensionecommerce.data.ok.Apis;
import com.bawei.dimensionecommerce.data.ok.Contans;
import com.bawei.dimensionecommerce.di.contract.IContract;
import com.bawei.dimensionecommerce.di.presenter.ILoginRegisterPresenter;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity implements IContract.IView {

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
    @BindView(R.id.activity_login_password)
    EditText activityLoginPassword;
    @BindView(R.id.Passwordswitching)
    ImageButton Passwordswitching;
    @BindView(R.id.buju2)
    ConstraintLayout buju2;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.loginSubmit)
    Button loginSubmit;
    private ILoginRegisterPresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        presenter = new ILoginRegisterPresenter();
        presenter.attachView(this);

    }

    @OnClick({R.id.register, R.id.loginSubmit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.loginSubmit:
                loadData();
                break;
                default:
                    break;
        }
    }

    private void loadData() {
        Map<String, String> parmas = new HashMap<>();
        parmas.put(Contans.POST_REGISTER_KEY_PHONE, activityLoginPhone.getText().toString().trim());
        parmas.put(Contans.POST_REGISTER_KEY_PASSWORD, activityLoginPassword.getText().toString().trim());
        presenter.requstRegisterData(Apis.REGISTER_URL, parmas, RegisterBean.class);
    }


    @Override
    public void showData(Object responseData) {
        if (responseData instanceof RegisterBean) {
            RegisterBean bean = (RegisterBean) responseData;
            if (bean == null || !bean.getSuccess()) {
                Toast.makeText(RegisterActivity.this, bean.getMessage(), Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }


}
