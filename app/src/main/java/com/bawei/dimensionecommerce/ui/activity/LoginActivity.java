package com.bawei.dimensionecommerce.ui.activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.dimensionecommerce.R;
import com.bawei.dimensionecommerce.data.bean.LoginBean;
import com.bawei.dimensionecommerce.di.contract.IContractLogin;
import com.bawei.dimensionecommerce.di.presenter.ILoginPresenterImp;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IContractLogin.ILoginView{

    @BindView(R.id.login_phone)
    ImageButton loginPhone;
    @BindView(R.id.group)
    RadioGroup group;
    @BindView(R.id.activity_login_phone)
    EditText activityLoginPhone;
    @BindView(R.id.buju1)
    ConstraintLayout buju1;
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
    @BindView(R.id.Rememberpassword)
    CheckBox Rememberpassword;
    @BindView(R.id.register)
    TextView register;
    @BindView(R.id.loginSubmit)
    Button loginSubmit;
    private ILoginPresenterImp presenter;
    private SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new ILoginPresenterImp();
        presenter.attachView(this);

        //自动登录
        sharedPreferences = getSharedPreferences("RememberPassword",Context.MODE_PRIVATE);
        boolean RememberPasswordLogin = sharedPreferences.getBoolean("记住密码", false);
        if (RememberPasswordLogin){
            String rm_phone = sharedPreferences.getString("RM_phone", "");
            String rm_pass = sharedPreferences.getString("RM_Pass", "");
            activityLoginPhone.setText(rm_phone);
            activityLoginPassword.setText(rm_pass);
            Rememberpassword.setChecked(RememberPasswordLogin);
        }
    }

    @OnClick({R.id.loginSubmit,R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register:
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                break;
            case R.id.loginSubmit:
                String username = activityLoginPhone.getText().toString();
                String password = activityLoginPassword.getText().toString();
                presenter.ruquestRegisterData(username,password);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("记住密码", Rememberpassword.isChecked());
                edit.putString("RM_phone", username);
                edit.putString("RM_Pass", password);
                edit.commit();
                break;
        }
    }


    @Override
    public void showData(String responseData) {
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(responseData, LoginBean.class);
        if (loginBean.getMessage().equals("登录成功")){
            Toast.makeText(this,"登录成功",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,HomeActivity.class));
        }else {
            Toast.makeText(this,"登录失败，请重新登录",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
