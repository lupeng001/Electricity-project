package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import bean.ShowBean;
import bean.SouSuoBean;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class SouSuoAdapter extends RecyclerView.Adapter<SouSuoAdapter.ViewHolder> {
    Context context;
   SouSuoBean souSuoBean;

    public SouSuoAdapter(Context context, SouSuoBean souSuoBean) {
        this.context = context;
        this.souSuoBean = souSuoBean;
    }

    @NonNull
    @Override
    public SouSuoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.sousuoitem_layout, null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SouSuoAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(souSuoBean.getResult().get(i).getMasterPic()).into(viewHolder.imageView);
        viewHolder.name.setText(souSuoBean.getResult().get(i).getCommodityName());
        viewHolder.price.setText("￥"+souSuoBean.getResult().get(i).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return souSuoBean.getResult().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sousuoitem_image);
            name = itemView.findViewById(R.id.sousuoitem_name);
            price = itemView.findViewById(R.id.sousuoitem_price);
        }
    }
}
