package weektest.baway.com.weidu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import adapter.FootAdapter;
import bean.FootBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.p.Persion;

public class MyFootActivity extends AppCompatActivity {

    @BindView(R.id.foot_recycler)
    RecyclerView footRecycler;
    int page = 1;
    int count = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_foot);
        ButterKnife.bind(this);
        Persion persion =new Persion(this);
        persion.getfoot(page,count);
        footRecycler.setLayoutManager(new GridLayoutManager(this,2));
    }

    public void getShow(FootBean footBean) {
        FootAdapter footAdapter =new FootAdapter(this,footBean);
        footRecycler.setAdapter(footAdapter);
    }
}
