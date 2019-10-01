package adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import weektest.baway.com.weidu.PhotoActivity;
import weektest.baway.com.weidu.R;
import weektest.baway.com.weidu.ShowActivity;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    List<String> list=new ArrayList<>();
    Context context;
    private String url;
    private String[] split1;

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (split1.length==1){
            view = View.inflate(context, R.layout.item_next, null);
        }else if(split1.length==2||split1.length==4){
            view=View.inflate(context,R.layout.item_next2,null);
        }else{
            view=View.inflate(context,R.layout.item_next3,null);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.simp.setImageURI(split1[position]);
        holder.simp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,PhotoActivity.class);
                intent.putExtra("url",url);
                context.startActivity(intent);
            }
        });
    }
    public void getData(String url){
        this.url = url;
    };

    @Override
    public int getItemCount() {
        return split1.length;
    }

    public void clear() {
        list.clear();
    }

    public void addList(String[] split) {
        this.split1 = split;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView simp;
        public ViewHolder(View itemView) {
            super(itemView);
            simp=itemView.findViewById(R.id.simp);
        }
    }
}

