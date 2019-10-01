package weektest.baway.com.weidu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import adapter.CloseAdapter;
import bean.Addressbean;
import bean.ChaCarBean;
import bean.CreatOrderBean;
import bean.DateBean;
import bean.DateBeans;
import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.p.Persion;

public class CloseActivity extends BaseActivity {
    @BindView(R.id.close_recycler)
    RecyclerView closeRecycler;
    @BindView(R.id.close_sumcount)
    TextView closeSumcount;
    @BindView(R.id.close_sumprice)
    TextView closeSumprice;
    @BindView(R.id.close_shouhuoname)
    TextView closeShouhuoname;
    @BindView(R.id.close_shouhuophone)
    TextView closeShouhuophone;
    @BindView(R.id.close_shouhuoaddress)
    TextView closeShouhuoaddress;
    @BindView(R.id.close_commit)
    Button closeCommit;
    private int count = 1;
    private List<ChaCarBean.ResultBean.ShoppingCartListBean> list = new ArrayList<>();
    List<DateBeans> date = new ArrayList<>();
    private int commodityId;
    private int id;
    private Persion persion;
    int sum = 0;
    private CloseAdapter closeAdapter;
    private int getsum;
    private int userId;

    @Override
    protected void bindEvent() {
        closeCommit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < list.size(); i++) {

                    commodityId = list.get(i).getCommodityId();
                    date.add(new DateBeans(list.get(i).getCommodityId(),list.get(i).getCount()));
                }
                Gson gson = new Gson();
                String s = gson.toJson(date);
                CharSequence text = closeSumprice.getText();
                Double aDouble = Double.valueOf((String) text);
                persion.getorder(s,aDouble,id);
                Intent intent = new Intent(CloseActivity.this,PayActivity.class);

                intent.putExtra("prices",text);
                intent.putExtra("userId",userId+"");
                startActivity(intent);
            }

        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        EventBus.getDefault().register(this);

        ButterKnife.bind(this);
        closeAdapter = new CloseAdapter(this, list);
        closeRecycler.setAdapter(closeAdapter);
        closeAdapter.setprice(closeSumprice);
        closeAdapter.setcount(closeSumcount);

        closeAdapter.notifyDataSetChanged();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        closeRecycler.setLayoutManager(linearLayoutManager);
        persion = new Persion(this);
        persion.getclose();
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_close;
    }

    @Subscribe(threadMode = ThreadMode.POSTING, sticky = true)
    public void onChuanzhi(List<ChaCarBean.ResultBean.ShoppingCartListBean> list) {
            this.list = list;
    }


    public void getShow(Addressbean addressbean) {
        List<Addressbean.ResultBean> result = addressbean.getResult();

        for (int i = 0; i < result.size(); i++) {
            if (result.get(i).getWhetherDefault() == 1) {
                closeShouhuoname.setText(result.get(i).getRealName());
                closeShouhuophone.setText(result.get(i).getPhone());
                userId = result.get(i).getId();
                closeShouhuoaddress.setText(result.get(i).getAddress());
                id = result.get(i).getId();
            }

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public void getOrder(CreatOrderBean orderBean) {
        Log.i("qweqeqewq","dadad"+orderBean.getMessage());
    }
}
