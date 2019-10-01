package bawei.com.jmessage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.wd.doctor.R;

import java.util.List;
import java.util.Locale;

import cn.jpush.im.android.api.JMessageClient;
import cn.jpush.im.android.api.content.ImageContent;
import cn.jpush.im.android.api.content.TextContent;
import cn.jpush.im.android.api.event.MessageEvent;
import cn.jpush.im.android.api.model.Conversation;
import cn.jpush.im.android.api.model.Message;
import cn.jpush.im.android.api.options.MessageSendingOptions;
import cn.jpush.im.api.BasicCallback;

public class Activity_img extends AppCompatActivity {
    private String userName = "tLLEte1207133315";
    private Button btn_send;
    Conversation conversation;
    private EditText et_send;
    private List<Conversation> conversations;
    private String posts;
    private String send;
    private int position;
    private TextView title;
    private JG_details_Adapter mAdapter;
    private RecyclerView mRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        title = findViewById(R.id.tv_target_account);

        et_send = findViewById(R.id.jg_details_edit);
        btn_send = findViewById(R.id.btn_send);
        mRecycler = findViewById(R.id.jg_details_recy);

        position = getIntent().getIntExtra("position", 0);
        //设置消息接收 监听
        mRecycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mAdapter = new JG_details_Adapter(Activity_img.this);
        mRecycler.setAdapter(mAdapter);
        //设置消息接收 监听
        // 进入会话状态,不接收通知栏
        GlobalEventListener.setJG(this,false);

       //JMessageClient.enterSingleConversation(this.userName);
       JMessageClient.registerEventReceiver(this);
//        Conversation conversation = Conversation.createSingleConversation(userName, "c7f6a1d56cb8da740fd18bfa");
//        conversations = JMessageClient.getConversationList();
//        conversation = conversations.get(1);
//        conversations1 = Conversation.createSin
// gleConversation(userName, "c7f6a1d56cb8da740fd18bfa");
//        JMessageClient.createSingleTextMessage(userName, "c7f6a1d56cb8da740fd18bfa", send);

        conversation = Conversation.createSingleConversation(userName,"c7f6a1d56cb8da740fd18bfa");


        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                send = et_send.getText().toString();
                final Message message = conversation.createSendMessage(new TextContent(send));
//                Message message1 = conversation.createSendMessage(new TextContent(send));
                message.setOnSendCompleteCallback(new BasicCallback() {
                    @Override
                    public void gotResult(int responseCode, String responseDesc) {
                        if (responseCode == 0) {
                            //消息发送成功
                            initData();
                        } else {
                            //消息发送失败
                        }
                    }
                });
//                MessageSendingOptions options = new MessageSendingOptions();
//                options.setRetainOffline(false);
                JMessageClient.sendMessage(message);//使用默认控制参数发送消息
                List<Message> allMessage = conversation.getAllMessage();
            }
        });
    }
    public void onEvent(MessageEvent event) {
        //获取事件发生的会话对象
        Message message = event.getMessage();
        initData();
        System.out.println(String.format(Locale.SIMPLIFIED_CHINESE, "收到一条来自%s的在线消息。\n", conversation.getTargetId()));
    }

    boolean one ;
    public void initData() {
        /*  List<Conversation> msgList = JMessageClient.getConversationList();*/
        /*if (msgList != null) {
            if (msgList.size() > 0) {
                if (msgList.get(position) != null) {
                    conversation = msgList.get(position);
                    //重置会话未读消息数
                    conversation.resetUnreadCount();

                }
            }
        }*/

            //userName = "f8443445-a7ef-47d8-8005-b0d57851b396";  //todo 可自定义

            //使列表滚动到底部
            if (conversation.getAllMessage() != null) {
                List<Message> allMessage = conversation.getAllMessage();
                Log.i("aaa", "initData: "+allMessage);
                if (conversation.getAllMessage().size() > 0) {
                    mAdapter.setData(conversation.getAllMessage());
                    //设置刷新不闪屏
                    ((SimpleItemAnimator) mRecycler.getItemAnimator()).setSupportsChangeAnimations(false);
                    if (one) {
                        mAdapter.notifyDataSetChanged();
                    } else {
                        mAdapter.notifyItemInserted(conversation.getAllMessage().size() - 1);
                    }
                    mRecycler.smoothScrollToPosition(conversation.getAllMessage().size());
                }
            }

        one=false; // 代表不是第一次initData

    }

    @Override
    protected void onDestroy() {
        JMessageClient.exitConversation();
        //设置消息接收 监听
        GlobalEventListener.setJG(null, false);
        JMessageClient.unRegisterEventReceiver(this);
        super.onDestroy();

    }
}