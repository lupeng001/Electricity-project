package frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;


import adapter.ShouyeAdapter;
import bean.ShowBean;
import mvp.p.Persion;
import weektest.baway.com.weidu.R;
import weektest.baway.com.weidu.SouSuoActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class HomeFragment extends BaseFragment{
    private RecyclerView recyclerView;
    private Button search;
    @Override
    protected void bindEvent() {
    search.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent =new Intent(getContext(),SouSuoActivity.class);
            startActivity(intent);
        }
    });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.recycler);
        search = bindView(R.id.bun_search);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Persion persion =new Persion(this);
        persion.getShow();
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected int bindLayout() {
        return R.layout.home_fragment;
    }

    public void getshow(ShowBean showBean) {
        ShouyeAdapter shouyeAdapter =new ShouyeAdapter(getContext(),showBean);
        recyclerView.setAdapter(shouyeAdapter);
    }
}
