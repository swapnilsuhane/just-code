package lld.service;

import lld.dao.VideoDao;
import lld.dao.VideoDaoImpl;

import java.util.List;

public class TopKVideoImpl implements TopKVideo {
    VideoDao videoDao;

    public TopKVideoImpl(VideoDao videoDao) {
        this.videoDao = new VideoDaoImpl();
    }

    @Override
    public void view(String videoId) {
        videoDao.incrementAndSaveView(videoId);
    }

    @Override
    public List<String> topK(int k) {
        return videoDao.findTopKVideo(k);
    }
}
