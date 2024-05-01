package lld.dao;

import java.util.List;

public interface VideoDao {

    void incrementAndSaveView(String videoId);

    List<String> findTopKVideo(int k);
}
