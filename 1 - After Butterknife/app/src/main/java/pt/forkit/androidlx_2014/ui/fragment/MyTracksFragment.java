package pt.forkit.androidlx_2014.ui.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnItemClick;
import pt.forkit.androidlx_2014.R;
import pt.forkit.androidlx_2014.domain.Track;
import pt.forkit.androidlx_2014.ui.BaseFragment;
import pt.forkit.androidlx_2014.ui.adapter.SongAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MyTracksFragment extends BaseFragment {

    @InjectView(R.id.gv_songs)
    GridView mGvSongs;

    private List<Track> mTracks;

    @OnItemClick(R.id.gv_songs)
    public void onTrackClick(int position){
        Track t = (Track) mGvSongs.getItemAtPosition(position);
        Intent intent = new Intent();
        intent.setAction(android.content.Intent.ACTION_VIEW);
        File file = new File("file_path_here");
        intent.setDataAndType(Uri.fromFile(file), "audio/*");
        startActivity(intent);
    }

    public static MyTracksFragment newInstance() {
        MyTracksFragment fragment = new MyTracksFragment();
        return fragment;
    }

    public MyTracksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tracks, container, false);
        ButterKnife.inject(this, v);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        mTracks = new ArrayList<Track>();
        fillTracks();
    }

    private void fillTracks() {
        mGvSongs.setAdapter(new SongAdapter(new ArrayList<Track>(mTracks), getActivity(), false));
    }

}
