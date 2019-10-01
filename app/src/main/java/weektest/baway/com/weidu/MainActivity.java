package weektest.baway.com.weidu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import bean.LoginBean;
import mvp.p.Persion;

public class MainActivity extends BaseActivity {
private ImageView eye;
private EditText password,phone;
private boolean isHideFirst = true;
private Button commit;
private TextView register;
private CheckBox checkBox;
    private SharedPreferences sp;
    private String user;
    private String pass;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {
        eye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isHideFirst==true){
                    HideReturnsTransformationMethod method = HideReturnsTransformationMethod.getInstance();
                    password.setTransformationMethod(method);
                    isHideFirst =false;
                }else {
                    PasswordTransformationMethod method = PasswordTransformationMethod.getInstance();
                    password.setTransformationMethod(method);
                    isHideFirst =true;
                }
            }
        });
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = phone.getText().toString();
                pass = password.getText().toString();
                if (user.equals("")|| pass.equals("")){
                    ToastData("账号或密码不能为空");
                }else {
                    Persion persion =new Persion(MainActivity.this);
                    persion.getlogin(user, pass);

                }
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void initView() {
        eye = findViewById(R.id.login_eye);
        password = findViewById(R.id.login_password);
        phone = findViewById(R.id.login_phone);
        commit = findViewById(R.id.login_commit);
        checkBox = findViewById(R.id.login_check);
        register = findViewById(R.id.login_register);
        //获取sp

        sp = getSharedPreferences("Login", Context.MODE_PRIVATE);
        boolean one = sp.getBoolean("one", false);
        if (one){
            phone.setText(sp.getString("uphone",""));
            password.setText(sp.getString("upwd",""));
            checkBox.setChecked(true);
        }
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }

    public void getShow(LoginBean loginBean1) {
        String status = loginBean1.getStatus();
        if (status.equals("0000")){

            SharedPreferences.Editor edit1 = sp.edit();
            edit1.putString("userId",loginBean1.getResult().getUserId()+"");
            edit1.putString("sessionId",loginBean1.getResult().getSessionId());
            edit1.commit();
            Intent intent =new Intent(this,ShowActivity.class);
            startActivity(intent);
            //如果登录成功记住秘密啊
            if (checkBox.isChecked()){
                SharedPreferences.Editor edit = sp.edit();
                edit.putString("uphone",user);
                edit.putString("upwd",pass);
                edit.putBoolean("one",true);
                edit.commit();
            }else {
                //不记住密码
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("uname", null);
                editor.putString("upswd", null);
                editor.putBoolean("one", false);
                editor.commit();

            }

        }else {
            ToastData("账号或密码不正确");
        }
    }
}
