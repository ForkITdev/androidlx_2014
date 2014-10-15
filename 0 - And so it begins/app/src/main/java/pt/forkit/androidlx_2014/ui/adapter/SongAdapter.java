package pt.forkit.androidlx_2014.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import pt.forkit.androidlx_2014.R;
import pt.forkit.androidlx_2014.domain.Track;

import java.util.ArrayList;

/**
 
 */
public class SongAdapter extends BaseAdapter {

    private final boolean showDownload;
    private ArrayList<Track> mTracks;
    private Context ctx;
    LayoutInflater inflater;

    public SongAdapter(ArrayList<Track> tracks, Context ctx, boolean showDownload) {
        this.ctx = ctx;
        mTracks = new ArrayList<Track>();

        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.showDownload = showDownload;
    }

    @Override
    public int getCount() {
        return mTracks.size();
    }

    @Override
    public Track getItem(int i) {
        return mTracks.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = inflater.inflate(R.layout.grid_item_song, null, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

        final Track t = getItem(i);

        if(showDownload){

        } else {
            holder.tv_label_download.setText(ctx.getString(R.string.play_song));
        }

        return view;
    }

    static class ViewHolder {
        TextView tv_title;
        ImageView iv_artwork;
        TextView tv_label_download;

        public ViewHolder(View view) {
            tv_title = (TextView) view.findViewById(R.id.tv_title);
            iv_artwork = (ImageView) view.findViewById(R.id.iv_artwork);
            tv_label_download = (TextView) view.findViewById(R.id.tv_label_download);
        }
    }

}
