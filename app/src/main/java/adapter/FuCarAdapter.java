package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

import bean.ChaCarBean;
import weektest.baway.com.weidu.R;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class FuCarAdapter extends RecyclerView.Adapter<FuCarAdapter.ViewHolder> {
    Context context;
    ChaCarBean chaCarBean;
    private List<ChaCarBean.ResultBean.ShoppingCartListBean> shoppingCartList;

    public FuCarAdapter(Context context, ChaCarBean chaCarBean) {
        this.context = context;
        this.chaCarBean = chaCarBean;
    }

    @NonNull
    @Override
    public FuCarAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.carfu_item, null, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final FuCarAdapter.ViewHolder viewHolder,final int i) {
        final List<ChaCarBean.ResultBean> result = chaCarBean.getResult();
        shoppingCartList = result.get(i).getShoppingCartList();
        viewHolder.name.setText(result.get(i).getCategoryName());
        viewHolder.checkBox.setChecked(result.get(i).isCheck());
        final CarAdapter carAdapter =new CarAdapter(context, shoppingCartList);
        viewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context));
        viewHolder.recyclerView.setAdapter(carAdapter);
        carAdapter.setChildListener(new CarAdapter.onChildListener() {
            @Override
            public void onChild() {
                if (groupListener != null) {
                    groupListener.onGroup(result);
                }
                //声明  变量  为 true
                boolean ischecked = true;
                //遍历 商品 信息
                for (int j = 0; j < result.size(); j++) {
                    boolean ischecked1 = result.get(j).isCheck();//获取商品的状态
                    if (!ischecked1) {//商品没有选中的话
                        ischecked = false; //把刚刚定义的变量设为false
                        break;
                    }
                }
                //通过商品状态 来改变商家状态
                viewHolder.checkBox.setChecked(ischecked);
                //通过商品状态 来改变商家状态
            }
        });
        //商家控制 商品   shang1是   商家的checkbox
        //给商家设置点击事件
        viewHolder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 改变商家的状态
                viewHolder.checkBox.setChecked(viewHolder.checkBox.isChecked());
                // 改变商品的状态  调用 商品适配器内的  setCheckChild()方法
                carAdapter.setCheckChild(viewHolder.checkBox.isChecked());
            }
        });

    }

    @Override
    public int getItemCount() {
        return chaCarBean.getResult().size();
    }

    public List<ChaCarBean.ResultBean.ShoppingCartListBean> getData() {
        return shoppingCartList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CheckBox checkBox;
        TextView name;
        RecyclerView recyclerView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.fu_check);
            name = itemView.findViewById(R.id.fucar_name);
            recyclerView = itemView.findViewById(R.id.fucar_cecycler);
        }
    }
    public interface onGroupListener {
        void onGroup( List<ChaCarBean.ResultBean> result);
    }

    public onGroupListener groupListener;

    public void setGroupListener(onGroupListener groupListener) {
        this.groupListener = groupListener;
    }

}
