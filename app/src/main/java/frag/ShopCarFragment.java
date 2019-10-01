package frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import adapter.CarAdapter;
import adapter.FuCarAdapter;
import bean.ChaCarBean;
import mvp.p.Persion;
import weektest.baway.com.weidu.CloseActivity;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class ShopCarFragment extends BaseFragment implements View.OnClickListener {
    private RecyclerView car_recycler;
    private CheckBox car_chckbox;
    private TextView sum;
    private Button commit;
    private FuCarAdapter carAdapter;
    private List<ChaCarBean.ResultBean> result;
    private ChaCarBean chaCarBean1;

    @Override
    protected void bindEvent() {
        commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<ChaCarBean.ResultBean.ShoppingCartListBean> list = new ArrayList<>();
                List<ChaCarBean.ResultBean.ShoppingCartListBean> data = carAdapter.getData();
                for (int i = 0; i < data.size(); i++) {
                    ChaCarBean.ResultBean.ShoppingCartListBean resultBean = data.get(i);
                    if (resultBean.isChecked()){
                       list.add(resultBean);
                    }
                }
                EventBus.getDefault().postSticky(list);
                Intent intent =new Intent(getContext(),CloseActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void initData() {
        car_chckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    for (int i = 0; i < chaCarBean1.getResult().size(); i++) {
                        chaCarBean1.getResult().get(i).setCheck(isChecked);
                        List<ChaCarBean.ResultBean.ShoppingCartListBean> shoppingCartList = chaCarBean1.getResult().get(i).getShoppingCartList();
                        for (int j = 0; j < shoppingCartList.size(); j++) {
                            shoppingCartList.get(j).setChecked(isChecked);
                            carAdapter.notifyDataSetChanged();
                        }
                    }
                }else {
                    for (int i = 0; i < chaCarBean1.getResult().size(); i++) {
                        chaCarBean1.getResult().get(i).setCheck(false);

                        List<ChaCarBean.ResultBean.ShoppingCartListBean> shoppingCartList = chaCarBean1.getResult().get(i).getShoppingCartList();
                        for (int j = 0; j < shoppingCartList.size(); j++) {
                            shoppingCartList.get(j).setChecked(false);
                            carAdapter.notifyDataSetChanged();
                        }
                    }
                }
            }

        });
    }

    @Override
    protected void initView() {
      car_recycler =   bindView(R.id.car_recycler);
      sum = bindView(R.id.car_price);
      car_chckbox = bindView(R.id.car_check);
      commit = bindView(R.id.car_commit);
      car_chckbox.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Persion persion =new Persion(this);
        persion.getchacar();
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        car_recycler.setLayoutManager(linearLayoutManager);
    }


    @Override
    protected int bindLayout() {
        return R.layout.shopcar_fragment;
    }

    public void getShow(final ChaCarBean chaCarBean) {
        chaCarBean1 = chaCarBean;
        Log.i("sqweqwe","sdada"+chaCarBean.getMessage());
        carAdapter = new FuCarAdapter(getContext(),chaCarBean);
        result = chaCarBean.getResult();
        car_recycler.setAdapter(carAdapter);
        shangjia();;
    }

    private void shangjia() {//商拼控制全选
        carAdapter.setGroupListener(new FuCarAdapter.onGroupListener() {
            @Override
            public void onGroup(List<ChaCarBean.ResultBean> data1) {
                int price = 0; //这是一个价格
                int num1 = 0;//商品得数量
                int num2 = 0;//商品选中数量
                for (int i = 0; i < data1.size(); i++) {
                    List<ChaCarBean.ResultBean.ShoppingCartListBean> list = data1.get(i).getShoppingCartList();
                    for (int j = 0; j < list.size(); j++) {   //商品
                        num1++; //商品数量++
                        boolean ischecked = list.get(j).isChecked();//商品的状态
                        if (ischecked) {//如果 商品的状态为  true的话
                            num2++;  //就把商品选中的数量  ++
                            //计算选中商品的价格
                            price += data1.get(i).getShoppingCartList().get(j).getCount() * data1.get(i).getShoppingCartList().get(j).getPrice();
                        }
                    }
                }
                //在循坏外面判断 如果商品的数量==选中商品的数量
                if (num1 == num2) {
                    car_chckbox.setChecked(true);//把全选的checkbox 设置为true
                } else {       //把全选的checkbox 设置为false
                    car_chckbox.setChecked(false);
                }
                //设置价格
                sum.setText(price + "");
            }
        });
    }

    //全选 /反选的点击事件
    @Override
    public void onClick(View view) {
        setOntListChick(car_chckbox.isChecked());
    }

    //全选 /反选
    private void setOntListChick(boolean checked) {
        int prices = 0;//价格
        if (checked) {//如果 全选checkbox为 true的话
            for (int i = 0; i < result.size(); i++) {  //就把  商家 循环  便利
                result.get(i).setCheck(true);//    设为true
                for (int j = 0; j < result.get(i).getShoppingCartList().size(); j++) {//商品 循环  便利
                    //商品也设为 true
                    result.get(i).getShoppingCartList().get(j).setChecked(true);
                    // //如果  商品为true的true的话计算价格
                    prices += result.get(i).getShoppingCartList().get(j).getCount() * result.get(i).getShoppingCartList().get(j).getPrice();
                }
            }

        } else {//  如果   全选的CheckBox为false的话
            for (int i = 0; i < result.size(); i++) {//遍历商家
                //遍历商家 设为 false
                result.get(i).setCheck(false);
                for (int j = 0; j < result.get(i).getShoppingCartList().size(); j++) {
                    //遍历商品 设为 false
                    result.get(i).getShoppingCartList().get(j).setChecked(false);
                }
            }

        }
        //刷新适配器
        carAdapter.notifyDataSetChanged();
        //这边是给价格 赋值
        sum.setText(prices + "");
    }

}
