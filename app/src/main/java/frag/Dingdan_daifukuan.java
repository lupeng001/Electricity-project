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
import adapter.WaitOrderAdapter;
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
public class Dingdan_daifukuan extends BaseFragment {
    @BindView(R.id.order_wait_recycler)
    RecyclerView orderWaitRecycler;
    Unbinder unbinder;
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Persion persion = new Persion(this);
        persion.getwaitorder(1, 1, 10);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        orderWaitRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int bindLayout() {
        return R.layout.dingdandaifukuan_fragment;
    }

    public void getShow(OrderAllBean orderAllBean) {
        OrderFatherAdapter orderFatherAdapter =new OrderFatherAdapter(getContext(),orderAllBean);
        orderWaitRecycler.setAdapter(orderFatherAdapter);
        orderFatherAdapter.notifyDataSetChanged();
//        for (int i = 0; i < orderAllBean.getOrderList().size(); i++) {
//            list = orderAllBean.getOrderList().get(i).getDetailList();
//        }
//        OrderAllAdapter orderAllAdapter =new OrderAllAdapter(getContext(),list);
//        orderWaitRecycler.setAdapter(orderAllAdapter);
//        orderAllAdapter.notifyDataSetChanged();
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
}
