package adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.OrderAllBean;
import util.MyView;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class OrderAllAdapter extends RecyclerView.Adapter<OrderAllAdapter.ViewHolder> {
    Context context;
    List<OrderAllBean.OrderListBean.DetailListBean> orderAllBean  = new ArrayList<>();

    public OrderAllAdapter(Context context, List<OrderAllBean.OrderListBean.DetailListBean> orderAllBean) {
        this.context = context;
        this.orderAllBean = orderAllBean;
    }

    @NonNull
    @Override
    public OrderAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.orderall_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAllAdapter.ViewHolder viewHolder, int i) {
        String pic = orderAllBean.get(i).getCommodityPic();
        String[] split = pic.split(",");
        List<String> sp = new ArrayList<>();
        for (int j = 0; j < split.length; j++) {
            sp.add(split[i]);
        }
        Glide.with(context).load(sp.get(1)).into(viewHolder.imageView);
        viewHolder.code.setText(orderAllBean.get(i).getOrderDetailId()+"");
        viewHolder.price.setText(orderAllBean.get(i).getCommodityPrice()+"");
    }

    @Override
    public int getItemCount() {
        return orderAllBean.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView price,code;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            code = itemView.findViewById(R.id.orderall_name);
            price = itemView.findViewById(R.id.orderall_price);
            imageView = itemView.findViewById(R.id.orderall_image);
        }
    }
}
