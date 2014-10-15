package pt.forkit.androidlx_2014.domain;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import com.google.gson.annotations.SerializedName;
import pt.forkit.androidlx_2014.rest.constants.Urls;

import java.util.List;

/**

 */

@Table(name = "Tracks")
public class Track extends Model {

    @Column
    @SerializedName("id")
    private int trackId;

    @Column
    @SerializedName("title")
    private String title;

    @Column
    @SerializedName("sharing")
    private String sharing;

    @Column
    @SerializedName("artwork_url")
    private String artworkUrl;

    @Column
    @SerializedName("duration")
    private long duration;

    @Column
    @SerializedName("genre")
    private String genre;

    @Column
    @SerializedName("streamable")
    private boolean streamable;

    @Column
    @SerializedName("downloadable")
    private boolean downloadable;

    @Column
    @SerializedName("download_url")
    private String downloadUrl;

    @Column
    @SerializedName("stream_url")
    private String streamUrl;

    @Column
    @SerializedName("original_content_size")
    private long originalContentSize;

    @Column
    private String localPath;

    public Track() {
    }

    public int getTrackId() {
        return trackId;
    }

    public String getTitle() {
        return title;
    }

    public String getSharing() {
        return sharing;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public long getDuration() {
        return duration;
    }

    public String getGenre() {
        return genre;
    }

    public boolean isStreamable() {
        return streamable;
    }

    public boolean isDownloadable() {
        return downloadable;
    }

    public String getDownloadUrl() {
        return downloadUrl + "?client_id=" + Urls.SOUNDCLOUD_CLIENT_ID;
    }

    public long getOriginalContentSize() {
        return originalContentSize;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }

    public static List<Track> getAll() {
        return new Select()
                .from(Track.class)
                .execute();
    }
}
