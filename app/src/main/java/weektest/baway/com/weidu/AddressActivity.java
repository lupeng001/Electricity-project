package weektest.baway.com.weidu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import java.util.List;

import adapter.AddressAdapter;
import bean.Addressbean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.p.Persion;

public class AddressActivity extends AppCompatActivity {

    @BindView(R.id.add_address)
    Button addAddress;
    @BindView(R.id.address_recycler)
    RecyclerView addressRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        ButterKnife.bind(this);
        Persion persion = new Persion(this);
        persion.getaddress();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        addressRecycler.setLayoutManager(linearLayoutManager);
    }

    public void getShow(Addressbean addressbean) {
        AddressAdapter addressAdapter = new AddressAdapter(this);
        List<Addressbean.ResultBean> result = addressbean.getResult();
        addressAdapter.setData(result);
        addressRecycler.setAdapter(addressAdapter);
    }

    @OnClick(R.id.add_address)
    public void onViewClicked() {
        Intent intent =new Intent(this,AddaddressActivity.class);
        startActivity(intent);
    }
}
