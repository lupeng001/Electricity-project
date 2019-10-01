package adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.UnicodeSet;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import bean.OrderAllBean;
import bean.WaitOrderBean;
import mvp.p.Persion;
import weektest.baway.com.weidu.AddPinglunActivity;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class PinglunOrderAdapter extends RecyclerView.Adapter<PinglunOrderAdapter.ViewHolder> {
    Context context;
    OrderAllBean orderAllBean;
    private String orderId;
    private WaitOrderBean waitOrderBean1;
    private Persion persion;

    public PinglunOrderAdapter(Context context, OrderAllBean orderAllBean) {
        this.context = context;
        this.orderAllBean = orderAllBean;
    }

    @NonNull
    @Override
    public PinglunOrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.pinglunorderitem_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PinglunOrderAdapter.ViewHolder viewHolder, final int i) {
        List<OrderAllBean.OrderListBean> list = orderAllBean.getOrderList();
        viewHolder.dingdanhao.setText(list.get(i).getOrderId()+"");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       Date date = new Date(System.currentTimeMillis());
       viewHolder.time.setText(formatter.format(date)+"");
       viewHolder.name.setText(list.get(i).getExpressCompName());
        orderId = list.get(i).getOrderId();
        viewHolder.danhao.setText(list.get(i).getOrderId()+"");
       viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        List<OrderAllBean.OrderListBean.DetailListBean> detailList = list.get(i).getDetailList();
        final OrderAllAdapter orderAllAdapter = new OrderAllAdapter(context,detailList);
        viewHolder.recyclerView.setAdapter(orderAllAdapter);
        viewHolder.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int userId = orderAllBean.getOrderList().get(i).getDetailList().get(i).getCommodityId();
                String orderId = orderAllBean.getOrderList().get(i).getOrderId();
                Intent intent =new Intent(context,AddPinglunActivity.class);
                intent.putExtra("orderId",orderId);
                List<OrderAllBean.OrderListBean> orderList = orderAllBean.getOrderList();
                EventBus.getDefault().postSticky(orderList);
                intent.putExtra("i",i);
                String ss = String.valueOf(userId);
                intent.putExtra("usetId",ss);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderAllBean.getOrderList().size();
    }

    public void getShow(WaitOrderBean waitOrderBean) {
        if (waitOrderBean.getStatus().equals("0000")){
            Toast.makeText(context,waitOrderBean.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dingdanhao,time,name,danhao;
        Button commit;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          dingdanhao = itemView.findViewById(R.id.waitorder_dingdanhao);
          time = itemView.findViewById(R.id.waitorder_time);
          name = itemView.findViewById(R.id.waitorder_name);
          danhao = itemView.findViewById(R.id.waitorder_kudidanhao);
          commit = itemView.findViewById(R.id.waitorder_commit);
          recyclerView = itemView.findViewById(R.id.waitorder_recycler);


        }
    }
}
