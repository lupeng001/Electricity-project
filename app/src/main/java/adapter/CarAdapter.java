package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import bean.ChaCarBean;
import bean.ShowBean;
import util.MyView;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    Context context;
    CheckBox checkBox;
    TextView price;
    private  int count = 0;
    private List<ChaCarBean.ResultBean.ShoppingCartListBean> result;

    public CarAdapter(Context context,     List<ChaCarBean.ResultBean.ShoppingCartListBean> shoppingCartList) {
        this.context = context;
        this.result = shoppingCartList;
    }

    @NonNull
    @Override
    public CarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.caritem_layout, null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CarAdapter.ViewHolder viewHolder, final int i) {
        Glide.with(context).load(result.get(i).getPic()).into(viewHolder.imageView);
        viewHolder.name.setText(result.get(i).getCommodityName());
        viewHolder.price.setText(result.get(i).getPrice()+"");
        viewHolder.caritem_check.setChecked(result.get(i).isChecked());
        viewHolder.myview.setData(this, result, i);
       viewHolder.myview.setNumCallBack(new MyView.numCallBack() {
           @Override
           public void getBack() {
               if (childListener != null) {
                   childListener.onChild();
               }
           }
       });

        //商品状态  改变
        viewHolder.caritem_check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (childListener != null) {
                    result.get(i).setChecked(b); //b或  true   或   false  因为在 onchengchenckdechangelisnenert
                    childListener.onChild();
                }
            }

        });
    }
    public void setCheckChild(boolean checked) {
        //商家适配器调用次方法
        //通过该方法实现商家内部商品全选
        for (int i = 0; i < result.size(); i++) {
            result.get(i).setChecked(checked);
        }
        //设置完状态  刷新适配器
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return result.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView name,price;
        CheckBox caritem_check;
        MyView myview;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.caritem_image);
            name = itemView.findViewById(R.id.caritem_name);
            price = itemView.findViewById(R.id.caritem_price);
            caritem_check = itemView.findViewById(R.id.caritem_check);
            myview = itemView.findViewById(R.id.caritem_myview);
        }
    }
    public interface onChildListener {
        void onChild();
    }

    public onChildListener childListener;

    public void setChildListener(onChildListener childListener) {
        this.childListener = childListener;
    }
}
