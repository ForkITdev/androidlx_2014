package pt.forkit.androidlx_2014.ui;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import pt.forkit.androidlx_2014.rest.AuthorizationInterceptor;
import pt.forkit.androidlx_2014.rest.Mp3Api;
import retrofit.RestAdapter;


@SuppressLint("NewApi")
public class BaseFragment extends Fragment {

    protected Mp3Api mApi;

    public BaseFragment() {
        super();
    }

    public void onCreate(Bundle s) {
        super.onCreate(s);

        RestAdapter  restAdapter = new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setRequestInterceptor(new AuthorizationInterceptor())
                .setEndpoint("http://api.soundcloud.com")
                .build();

        mApi = restAdapter.create(Mp3Api.class);

    }

}
