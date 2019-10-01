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

import java.util.List;

import bean.ShowBean;
import weektest.baway.com.weidu.R;
import weektest.baway.com.weidu.SouSuoActivity;
import weektest.baway.com.weidu.XiangActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class RxxpAdapter extends RecyclerView.Adapter<RxxpAdapter.ViewHolder> {
    Context context;
    List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list;

    public RxxpAdapter(Context context, List<ShowBean.ResultBean.RxxpBean.CommodityListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RxxpAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.rexpitem_layout, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RxxpAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(list.get(i).getMasterPic()).into(viewHolder.imageView);
        viewHolder.name.setText(list.get(i).getCommodityName());
        viewHolder.price.setText("￥"+list.get(i).getPrice()+"");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,XiangActivity.class);
                intent.putExtra("id",list.get(i).getCommodityId()+"");
                Log.i("adasdads","dasdada"+list.get(i).getCommodityId()+"");
                context.startActivity(intent);
            }
        });
        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.rxxpitem_image);
            name = itemView.findViewById(R.id.rxxpitem_name);
            price = itemView.findViewById(R.id.rxxpitem_price);
        }
    }
}
