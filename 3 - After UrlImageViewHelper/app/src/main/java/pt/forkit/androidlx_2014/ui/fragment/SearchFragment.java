package pt.forkit.androidlx_2014.ui.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Environment;
import android.view.*;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import pt.forkit.androidlx_2014.R;
import pt.forkit.androidlx_2014.domain.Track;
import pt.forkit.androidlx_2014.ui.BaseFragment;
import pt.forkit.androidlx_2014.ui.adapter.SongAdapter;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

import java.util.ArrayList;

public class SearchFragment extends BaseFragment {

    @InjectView(R.id.gv_songs)
    GridView mGvSongs;

    @OnItemClick(R.id.gv_songs)
    public void onSongClick(int position){
        Track t = (Track) mGvSongs.getItemAtPosition(position);
        onSongDownload(t);
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();

        return fragment;
    }
    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle s) {
        super.onCreate(s);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        MenuItem item = menu.add("Search");
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        final SearchView sv = new SearchView(getActivity());

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchSongs(s);
                sv.onActionViewCollapsed();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });

        item.setActionView(sv);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tracks, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        searchSongs("");
    }

    private void searchSongs(String query){
        final ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.show();

        mApi.tracks(query, "downloadable", new Callback<ArrayList<Track>>() {
            @Override
            public void success(ArrayList<Track> tracks, Response response) {
                dialog.hide();
                SongAdapter adapt = new SongAdapter(tracks, getActivity(), true);
                mGvSongs.setAdapter(adapt);
            }

            @Override
            public void failure(RetrofitError error) {
                dialog.hide();
            }
        });
    }

    public void onSongDownload(final Track t) {

        t.setLocalPath(Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_MUSIC + "/" + t.getTitle() + ".mp3");
        Toast.makeText(getActivity(), "Will download to: " + t.getLocalPath(), Toast.LENGTH_SHORT).show();

    }

}
