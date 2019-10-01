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

import java.util.ArrayList;
import java.util.List;

import bean.Addressbean;
import bean.ShowBean;
import util.MyApp;
import weektest.baway.com.weidu.R;
import weektest.baway.com.weidu.XiangActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder> {
    Context context;
  List<Addressbean.ResultBean> list = new ArrayList<>();

    public AddressAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public AddressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.addressitem_layout, null);
       return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddressAdapter.ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(list.get(i).getRealName());
        viewHolder.phone.setText(list.get(i).getPhone());

        viewHolder.address.setText(list.get(i).getAddress());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<Addressbean.ResultBean> result) {
        list.addAll(result);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name,phone,address,check,update,delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.address_name);
            phone = itemView.findViewById(R.id.address_phone);
            address = itemView.findViewById(R.id.address_address);

        }
    }
}
