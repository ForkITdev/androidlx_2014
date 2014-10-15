package pt.forkit.androidlx_2014;

import android.app.Application;
import com.activeandroid.ActiveAndroid;

/**
 
 */
public class AndroidLxMp3Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }

}
