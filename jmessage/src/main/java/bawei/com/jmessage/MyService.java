package bawei.com.jmessage;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public  class  MyService  extends Service {
    private static final String TAG = "myservice";

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i("---------------creat",this+"");

    }

    @Override
    public void onDestroy() {
        Log.e(TAG, "destory:");
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onCreate:");
        return super.onStartCommand(intent, flags, startId);
    }
}

