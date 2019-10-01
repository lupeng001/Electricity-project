package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import bean.ChaCarBean;
import util.MyView;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class CloseAdapter extends RecyclerView.Adapter<CloseAdapter.ViewHolder> {
  Context context;
int sums;
 List<ChaCarBean.ResultBean.ShoppingCartListBean> list = new ArrayList<>();
TextView price;
TextView count;
    public CloseAdapter(Context context, List<ChaCarBean.ResultBean.ShoppingCartListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CloseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.closeitem_layout, null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CloseAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(list.get(i).getPic()).into(viewHolder.imageView);
        viewHolder.name.setText(list.get(i).getCommodityName());
        viewHolder.price.setText(list.get(i).getPrice()+"");
        zongjia();
        shuliang();
    }

    private void shuliang() {

        int counts = 0;
        for (int i = 0; i < list.size(); i++) {
            counts += list.get(i).getCount();
        }
        count.setText(counts+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
        //Activity 的总价
    public void setsum(TextView sum) {
        this.price = sum;
        notifyDataSetChanged();
    }

private void zongjia(){
        //初始化价钱
    int sum = 0;
    for (int i = 0; i <list.size() ; i++) {
        sum +=list.get(i).getCount()*list.get(i).getPrice();
    }
    sums= sum;
    price.setText(sum+"");


}

    public void setprice(TextView closeSumprice) {
             this.price = closeSumprice;
             notifyDataSetChanged();
    }

    public void setcount(TextView closeSumcount) {
        this.count = closeSumcount;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price;
        CheckBox caritem_check;
        MyView myView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.close_image);
            name = itemView.findViewById(R.id.close_name);
            price = itemView.findViewById(R.id.close_price);

        }
    }
//    OnclickItemCallBack onclickItemCallBack;
//    public void OnCallBak(OnclickItemCallBack onclickItemCallBack){
//        this.onclickItemCallBack = onclickItemCallBack;
//    }
//    public interface OnclickItemCallBack{
//        void getData(int sum);
//    }
}
