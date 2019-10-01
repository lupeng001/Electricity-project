package weektest.baway.com.weidu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import adapter.MyCricleAdapter;
import bean.MyCircleBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import mvp.p.Persion;

public class MyCircleActivity extends AppCompatActivity {
    @BindView(R.id.editor)
    TextView editor;
    @BindView(R.id.img_delete_mycircle)
    ImageView imgDeleteMycircle;
    @BindView(R.id.rlv_mycircle)
    XRecyclerView rlvMycircle;
    private int page = 1;
    private int count = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_circle);
        ButterKnife.bind(this);
        Persion persion = new Persion(this);
        persion.mycircle(page, count);
        rlvMycircle.setLayoutManager(new LinearLayoutManager(this));

    }

    public void getShow(MyCircleBean myCircleBean) {
        MyCricleAdapter myCricleAdapter =new MyCricleAdapter(this,myCircleBean.getResult());
        rlvMycircle.setAdapter(myCricleAdapter);
    }
    public interface onEditorLisenter {
        void onSendEditor();
    }

    private onEditorLisenter lisenter;

    public void setLisenter(onEditorLisenter lisenter) {
        this.lisenter = lisenter;
    }
}
