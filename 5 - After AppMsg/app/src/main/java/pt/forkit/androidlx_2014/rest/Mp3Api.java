package pt.forkit.androidlx_2014.rest;

import pt.forkit.androidlx_2014.domain.Track;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

import java.util.ArrayList;


public interface Mp3Api {

    @GET("/tracks.json")
    public void tracks(@Query("q") String query, @Query("tags") String tags,
                        Callback<ArrayList<Track>> callback);

    @GET("/track/{track_id}.json")
    public void track(@Path("track_id") String track_id,
                      Callback<Track> callback);


}
