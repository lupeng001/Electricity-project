package adapter;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import util.UIUtils;
import weektest.baway.com.weidu.R;


/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class CirCleAdapter  extends RecyclerView.Adapter<CirCleAdapter.ViewHolder> {
    private List<Object> mList = new ArrayList<>();
    private int sign;//0:普通点击，1自定义



    public void setSign(int sign){
        this.sign = sign;
    }

    @NonNull
    @Override
    public CirCleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,final int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.circle_image_item, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CirCleAdapter.ViewHolder viewHolder, final int i) {
        if (mList.get(i) instanceof String) {
            String imageUrl = (String) mList.get(i);
            if (imageUrl.contains("http:")) {//加载http
                viewHolder.image.setImageURI(Uri.parse(imageUrl));
            } else {//加载sd卡
                Uri uri = Uri.parse("file://" + imageUrl);
                viewHolder.image.setImageURI(uri);
            }
        } else {//加载资源文件
            int id = (int) mList.get(i);
            Uri uri = Uri.parse("res://com.weidu/" + id);
            viewHolder.image.setImageURI(uri);
        }
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sign == 1) {//自定义点击
                    if (i == 0) {
                        Intent intent = new Intent(
                                Intent.ACTION_PICK,
                                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void add(Object ic_launcher_background) {
        if (ic_launcher_background!=null){
            mList.add(ic_launcher_background);
        }
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.circle_image);
        }
    }
}
