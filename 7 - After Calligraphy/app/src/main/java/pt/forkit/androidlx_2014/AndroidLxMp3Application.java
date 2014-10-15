package pt.forkit.androidlx_2014;

import android.app.Application;
import com.activeandroid.ActiveAndroid;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 
 */
public class AndroidLxMp3Application extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
        CalligraphyConfig.initDefault("fonts/Roboto-Light.ttf", R.attr.fontPath);
    }

}
