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
public class Dingdan_daishouhuo extends BaseFragment {
    @BindView(R.id.order_withpay_recycler)
    RecyclerView orderWithpayRecycler;
    Unbinder unbinder;
    private List<OrderAllBean.OrderListBean.DetailListBean> list = new ArrayList<>();
    private int status = 2;
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

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Persion persion = new Persion(this);
        persion.getWithpayment(status, page, count);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        orderWithpayRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int bindLayout() {
        return R.layout.dingdandaishouhuo_fragment;
    }

    public void getShow(OrderAllBean orderAllBean) {

        WaitOrderAdapter waitOrderAdapter =new WaitOrderAdapter(getContext(),orderAllBean);
        orderWithpayRecycler.setAdapter(waitOrderAdapter);
        waitOrderAdapter.notifyDataSetChanged();
//        for (int i = 0; i < orderAllBean.getOrderList().size(); i++) {
//            list = orderAllBean.getOrderList().get(i).getDetailList();
//        }
//        OrderAllAdapter orderAllAdapter =new OrderAllAdapter(getContext(),list);
//        orderWithpayRecycler.setAdapter(orderAllAdapter);
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
