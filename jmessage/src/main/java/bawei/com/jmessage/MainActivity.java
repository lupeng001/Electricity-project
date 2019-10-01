package bawei.com.jmessage;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wd.doctor.R;

import java.util.List;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.callback.GetUserInfoCallback;
import cn.jpush.im.android.api.content.ImageContent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.UserInfo;
import cn.jpush.im.api.BasicCallback;

public class MainActivity extends AppCompatActivity {
private TextView title;
private EditText mEdit;
private RecyclerView mRecycler;
    private JG_details_Adapter mAdapter;
    private int position;
    private String userName = "MQtmPd2295587818";
private String jiGuangPwd = "mRUCs5zd+scQNoZQfdsXgYvbncR2oQzJdd/fQw0LfwozLShT7xKOzNhfypi5WZUAzhIl7DLQEnD78lAnsDLbtEe93d1iRVNZsU0nwiGtlBtr/UA4l5u5xPbiaywiouKBVzsJoABzrZ4xLiYF4tVue+0NVDOLMCphU7NaGmao7Cc=";
    private Conversation conversation;
    boolean one = true;
    private ImageView imageView;
    private Button start,stop;
    private EditText user,pwds;
    private Button commit,register;
    private String key;
    private String md5pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /// Required -注册DeviceToken
        //设置消息接收 监听
        //进入会话状态,不接收通知栏

        JMessageClient.enterSingleConversation(this.userName);
        commit =findViewById(R.id.commit);
        register = findViewById(R.id.register);
        user = findViewById(R.id.user);
        pwds = findViewById(R.id.pwd);
        try {
            key = RsaCoder.decryptByPublicKey(jiGuangPwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        md5pwd = MD5Utils.MD5(key);

commit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(MainActivity.this,TwoActivity.class);
        startActivity(intent);
    }
});

//        title = findViewById(R.id.jg_details_title);
//        mEdit = findViewById(R.id.jg_details_edit);
////        mRecycler = findViewById(R.id.jg_details_recy);
////        mRecycler.setLayoutManager(new LinearLayoutManager(this));
////        mAdapter = new JG_details_Adapter(this);
////        mRecycler.setAdapter(mAdapter);
////        //设置消息接收 监听
//        //进入会话状态,不接收通知栏


    }

    //

    private void getData(){
        JMessageClient.login(userName, md5pwd, new GetUserInfoCallback() {
            @Override
            public void gotResult(int i, String s, UserInfo userInfo) {
                if (i==0){
                    Toast.makeText(MainActivity.this,"获取成功",Toast.LENGTH_SHORT).show();
                    Intent intent =new Intent(MainActivity.this,Activity_img.class);
                    intent.putExtra("i",i);
                    intent.putExtra("s",s);
                    Log.i("dasdddddddddddd",""+s);
                    startActivity(intent);
                }
            }


        });
    }
}
