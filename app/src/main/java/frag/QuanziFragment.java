package frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import adapter.QuanziAdapter;
import bean.DianZanBean;
import bean.QuanziBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import mvp.p.Persion;
import weektest.baway.com.weidu.AddCircleActivity;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class QuanziFragment extends BaseFragment {
    @BindView(R.id.quanzi_xrecycler)
    XRecyclerView quanziXrecycler;
    Unbinder unbinder;
    @BindView(R.id.fly)
    ImageView fly;
    private int page = 1;
    private int count = 10;
    private Persion persion;

    @Override
    protected void bindEvent() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        //下垃加载
        quanziXrecycler.setPullRefreshEnabled(true);
        //上拉刷新
        quanziXrecycler.setLoadingMoreEnabled(true);
        quanziXrecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page = 1;
                persion.getquanzi(page, count);
                quanziXrecycler.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                page++;
                persion.getquanzi(page, count);
                quanziXrecycler.refreshComplete();
            }

        });

    }

    @Override
    protected int bindLayout() {
        return R.layout.quanzi_fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        persion = new Persion(this);
        persion.getquanzi(page, count);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        quanziXrecycler.setLayoutManager(linearLayoutManager);
    }

    public void getShow(QuanziBean quanziBean) {
        QuanziAdapter quanziAdapter = new QuanziAdapter(quanziBean, getContext());
        //点赞接口
        quanziAdapter.getDataCancle(new QuanziAdapter.OnItemClickListenter() {
            @Override
            public void getData(List<QuanziBean.ResultBean> lists, int position) {
                int commodityId = lists.get(position).getCommodityId();
                persion.getzan(commodityId);
            }
        });
        quanziXrecycler.setAdapter(quanziAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fly)
    public void onViewClicked() {
        Intent intent =new Intent(getContext(),AddCircleActivity.class);
        startActivity(intent);

    }

    public void getDianzan(DianZanBean dianZanBean) {
        if (dianZanBean.getStatus().equals("0000")){
            Toast.makeText(getContext(),dianZanBean.getMessage(),Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(getContext(),"点赞失败",Toast.LENGTH_LONG).show();
        }
    }
}
