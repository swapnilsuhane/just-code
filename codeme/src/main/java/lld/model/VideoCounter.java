package lld.model;

import java.util.concurrent.atomic.AtomicInteger;

public class VideoCounter {
    public AtomicInteger getViewCount() {
        return viewCount;
    }

    public void setViewCount(AtomicInteger viewCount) {
        this.viewCount = viewCount;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    String videoId;
    AtomicInteger viewCount;
}
