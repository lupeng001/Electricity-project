package weektest.baway.com.weidu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import adapter.MoneyAdapter;
import bean.MoneyBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.p.Persion;

public class MoneyActivity extends AppCompatActivity {

    @BindView(R.id.yue)
    TextView yue;
    @BindView(R.id.money)
    TextView money;
    @BindView(R.id.money_recycler)
    RecyclerView moneyRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_money);
        ButterKnife.bind(this);
        Persion persion = new Persion(this);
        persion.getmoney();
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this);
        moneyRecycler.setLayoutManager(linearLayoutManager);
    }

    public void getShow(MoneyBean moneyBean) {
        money.setText(moneyBean.getResult().getBalance() + "");
        List<MoneyBean.DatailList> list = moneyBean.getResult().getDetailList();
        MoneyAdapter moneyAdapter =new MoneyAdapter(this);
        moneyAdapter.addAll(list);
        moneyRecycler.setAdapter(moneyAdapter);
    }
}
