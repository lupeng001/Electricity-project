package util;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 作者;路鹏
 * 时间：$date$ $time$
 * 详细信息：
 */
public class MyApp extends Application {
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        getInstance();
        
    }

    public void getInstance() {

        context = getApplicationContext();
    }
    public static Context getContentInstace(){
        return context;
    }
}
