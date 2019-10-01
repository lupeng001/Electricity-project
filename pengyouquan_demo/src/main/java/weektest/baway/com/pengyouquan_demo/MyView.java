package weektest.baway.com.pengyouquan_demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyView extends View {

    private Paint paint;
    private int i;

    public MyView(Context context) {
        super(context);

        initView(context);
    }



    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }
    private void initView(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //取宽高最小值
        int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
        //圆的 半径是边长的一半
        i = min / 2;
        //强制 宽高 相等
        setMeasuredDimension(min,min);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(i,i,i,paint);
    }
}


