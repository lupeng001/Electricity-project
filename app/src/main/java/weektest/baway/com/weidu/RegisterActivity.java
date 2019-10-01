package weektest.baway.com.weidu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import bean.RegisterBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.p.Persion;

public class RegisterActivity extends BaseActivity {


    @BindView(R.id.register_phone)
    EditText registerPhone;
    @BindView(R.id.register_yanzheng)
    EditText registerYanzheng;
    @BindView(R.id.register_password)
    EditText registerPassword;
    @BindView(R.id.register_eye)
    ImageView registerEye;
    @BindView(R.id.login_register)
    TextView loginRegister;
    @BindView(R.id.register_commit)
    Button registerCommit;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }

    @OnClick(R.id.register_commit)
    public void onViewClicked() {
        String phone = registerPhone.getText().toString();
        String password = registerPassword.getText().toString();
        String yanzhengma = registerYanzheng.getText().toString();
        if (phone.equals("")||password.equals("")||yanzhengma.equals("")){
            ToastData("账号或密码不能为空");
        }else {
            Persion persion = new Persion(RegisterActivity.this);
            persion.getregister(phone,password);

        }
    }

    public void getshow(RegisterBean registerBean) {
        String status = registerBean.getStatus();
        if (status.equals("0000")){
            Intent intent =new Intent(RegisterActivity.this,MainActivity.class);
            startActivity(intent);
            ToastData("注册成功");
            finish();
        }
    }
}
