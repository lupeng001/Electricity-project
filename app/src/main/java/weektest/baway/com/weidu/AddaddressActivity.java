package weektest.baway.com.weidu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bean.AddAddressBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.p.Persion;

public class AddaddressActivity extends BaseActivity {

    @BindView(R.id.add_name)
    EditText addName;
    @BindView(R.id.add_phone)
    EditText addPhone;
    @BindView(R.id.add_adress)
    EditText addAdress;
    @BindView(R.id.add_dizhi)
    EditText addDizhi;
    @BindView(R.id.add_email)
    EditText addEmail;
    @BindView(R.id.add_comit)
    Button addComit;
    private String name;
    private String phone;
    private String address;
    private String dizhi;
    private String email;
    private Persion persion;


    @Override
    protected void bindEvent() {
        addComit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                name = addName.getText().toString();
                phone = addPhone.getText().toString();
                address = addAdress.getText().toString();
                dizhi = addDizhi.getText().toString();
                email = addEmail.getText().toString();
                if (name.equals("")||phone.equals("")||address.equals("")||email.equals("")){
                    Toast.makeText(AddaddressActivity.this,"添加不能为空",Toast.LENGTH_LONG).show();
                }else {
                    persion.getaddaddress(name,phone,address,email);
                    finish();
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        persion = new Persion(this);

    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_addaddress;
    }


    public void getShow(AddAddressBean addAddressBean) {
        String status = addAddressBean.getStatus();
        if (status.equals("0000")){
            Toast.makeText(this,"添加成功",Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"添加失败",Toast.LENGTH_LONG).show();
        }
    }
}
