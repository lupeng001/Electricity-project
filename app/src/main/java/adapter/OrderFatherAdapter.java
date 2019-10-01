package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.OrderAllBean;
import weektest.baway.com.weidu.PayActivity;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class OrderFatherAdapter extends RecyclerView.Adapter<OrderFatherAdapter.ViewHolder> {
    Context context;
    OrderAllBean orderAllBean;
    private String orderId;

    public OrderFatherAdapter(Context context, OrderAllBean orderAllBean) {
        this.context = context;
        this.orderAllBean = orderAllBean;
    }

    @NonNull
    @Override
    public OrderFatherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.orderfatther_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderFatherAdapter.ViewHolder viewHolder, int i) {
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
        OrderAllAdapter orderAllAdapter = new OrderAllAdapter(context,detailList);
        viewHolder.recyclerView.setAdapter(orderAllAdapter);

        viewHolder.commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,PayActivity.class);
                intent.putExtra("orderId", orderId);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return orderAllBean.getOrderList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView dingdanhao,time,name,danhao;
        Button commit;
        RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          dingdanhao = itemView.findViewById(R.id.orderfather_dingdanhao);
          time = itemView.findViewById(R.id.orderfather_time);
          name = itemView.findViewById(R.id.orderfather_name);
          danhao = itemView.findViewById(R.id.orderfather_kudidanhao);
          commit = itemView.findViewById(R.id.orderfather_commit);
          recyclerView = itemView.findViewById(R.id.orderfather_recycler);


        }
    }
}
