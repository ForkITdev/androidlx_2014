package pt.forkit.androidlx_2014.events;

/**
 
 */
public class MusicDownloadedEvent {
    public String path;

    public MusicDownloadedEvent(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
