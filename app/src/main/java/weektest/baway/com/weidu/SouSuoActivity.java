package weektest.baway.com.weidu;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import adapter.SouSuoAdapter;
import bean.SouSuoBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import mvp.p.Persion;

public class SouSuoActivity extends BaseActivity {

    @BindView(R.id.sousuo_pop)
    Button sousuoPop;
    @BindView(R.id.sousuo_edit)
    EditText sousuoEdit;
    @BindView(R.id.sousuo_commmit)
    Button sousuoCommmit;
    @BindView(R.id.sousuo_recycler)
    RecyclerView sousuoRecycler;
    private Persion persion;
    private int page = 1;
    private int count = 10;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        ButterKnife.bind(this);
        persion = new Persion(this);
        sousuoRecycler.setLayoutManager(new GridLayoutManager(this,2));
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_sou_suo;
    }

    @OnClick(R.id.sousuo_commmit)
    public void onViewClicked() {
        String keyword = sousuoEdit.getText().toString();
        if (keyword.equals("")) {
            ToastData("输入的关键字不能为空");
        } else {
            persion.getsousuo(keyword, page, count);
        }
    }

    public void getshow(SouSuoBean souSuoBean) {
        SouSuoAdapter souSuoAdapter =new SouSuoAdapter(this,souSuoBean);
        sousuoRecycler.setAdapter(souSuoAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
