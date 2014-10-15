package pt.forkit.androidlx_2014.ui.activity;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import com.devspark.appmsg.AppMsg;
import de.greenrobot.event.EventBus;
import pt.forkit.androidlx_2014.R;
import pt.forkit.androidlx_2014.events.MusicDownloadedEvent;
import pt.forkit.androidlx_2014.ui.BaseActivity;
import pt.forkit.androidlx_2014.ui.fragment.MyTracksFragment;
import pt.forkit.androidlx_2014.ui.fragment.NavigationDrawerFragment;
import pt.forkit.androidlx_2014.ui.fragment.SearchFragment;


public class MainActivity extends BaseActivity implements
        NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        EventBus.getDefault().register(this);
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if(position == 0){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, SearchFragment.newInstance())
                    .commit();
        } else if(position == 1){
            fragmentManager.beginTransaction()
                    .replace(R.id.container, MyTracksFragment.newInstance())
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    public void onEvent(MusicDownloadedEvent event) {
        sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + event.getPath())));
        AppMsg.makeText(this, "Media Scanner triggered.", AppMsg.STYLE_CONFIRM).show();
    }
}
