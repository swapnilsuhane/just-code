package lld.service;

import java.util.List;

public interface TopKVideo {

    void view(String videoId);

    List<String> topK(int k);
}
