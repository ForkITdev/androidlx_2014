package pt.forkit.androidlx_2014.domain;

import com.google.gson.annotations.SerializedName;
import pt.forkit.androidlx_2014.rest.constants.Urls;

import java.util.List;

/**

 */

public class Track {

    @SerializedName("id")
    private int trackId;

    @SerializedName("title")
    private String title;

    @SerializedName("sharing")
    private String sharing;

    @SerializedName("artwork_url")
    private String artworkUrl;

    @SerializedName("duration")
    private long duration;

    @SerializedName("genre")
    private String genre;

    @SerializedName("streamable")
    private boolean streamable;

    @SerializedName("downloadable")
    private boolean downloadable;

    @SerializedName("download_url")
    private String downloadUrl;

    @SerializedName("stream_url")
    private String streamUrl;

    @SerializedName("original_content_size")
    private long originalContentSize;

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

}
