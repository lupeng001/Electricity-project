package frag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import adapter.OrderAllAdapter;
import adapter.OrderFatherAdapter;
import bean.OrderAllBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import mvp.p.Persion;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class Dingdan_quanbu extends BaseFragment {
    @BindView(R.id.order_all_recycler)
    RecyclerView orderAllRecycler;
    Unbinder unbinder;
    private int status =0;
    int page = 1;
    int count = 10;
    private List<OrderAllBean.OrderListBean.DetailListBean> list = new ArrayList<>();

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
        return R.layout.dingdanquanbu_fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Persion persion =new Persion(this);
        persion.getorderall(status,page,count);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        orderAllRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    public void getShow(OrderAllBean orderAllBean) {

        OrderFatherAdapter orderFatherAdapter =new OrderFatherAdapter(getContext(),orderAllBean);
        orderAllRecycler.setAdapter(orderFatherAdapter);
        orderFatherAdapter.notifyDataSetChanged();
    }
}
