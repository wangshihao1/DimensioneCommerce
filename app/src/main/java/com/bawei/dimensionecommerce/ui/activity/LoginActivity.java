package com.bawei.dimensionecommerce.ui.activity;
import android.content.Intent;
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
import com.bawei.dimensionecommerce.R;
import com.bawei.dimensionecommerce.di.contract.IContract;
import com.bawei.dimensionecommerce.di.presenter.ILoginRegisterPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements IContract.IView,View.OnClickListener {

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
    private ILoginRegisterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new ILoginRegisterPresenter();
        presenter.attachView(this);
    }


    @OnClick({R.id.loginSubmit,R.id.register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.loginSubmit:
                String phones = activityLoginPhone.getText().toString();
                String password = Rememberpassword.getText().toString();
                break;
            case R.id.register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showData(Object responseData) {

    }
}
