package adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import bean.MoneyBean;
import bean.ShowBean;
import weektest.baway.com.weidu.R;
import weektest.baway.com.weidu.XiangActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MoneyAdapter extends RecyclerView.Adapter<MoneyAdapter.ViewHolder> {
    Context context;
List<MoneyBean.DatailList>  lists = new ArrayList<>();
    public MoneyAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MoneyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.moneyitem_layout, null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoneyAdapter.ViewHolder viewHolder, final int i) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(lists.get(i).getCreateTime());
        viewHolder.name.setText(dateString+"");
        viewHolder.price.setText("￥"+lists.get(i).getAmount()+"");
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public void addAll(List<MoneyBean.DatailList> list) {
        if (list!=null){
            lists.addAll(list);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.moneyirem_time);
            price = itemView.findViewById(R.id.moneyitem_price);
        }
    }
}
