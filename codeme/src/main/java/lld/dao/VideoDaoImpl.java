package lld.dao;

import lld.exception.VideoException;
import lld.model.VideoCountMessge;
import lld.model.VideoCounter;
import lld.mq.Publisher;

import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoDaoImpl implements VideoDao {
    private final int MaxK = 1000;
    private Publisher publisher;

    PriorityQueue<VideoCounter> minHeap = new PriorityQueue<>((v1, v2) -> comparator(v1, v2));

    private int comparator(VideoCounter v1, VideoCounter v2) {
        return 0;
    }


    @Override
    public void incrementAndSaveView(String videoId) {
        try {
            //publish mq
            VideoCountMessge videoCountMessge = createVideoMessage(videoId);
            publisher.publish(videoCountMessge);
            AtomicInteger curCount = getCurrentVideoCount(videoId);
            //update heap
            updateTopKVideo(videoId, curCount);
        } catch (VideoException e) {
            System.out.println(e);
        }
    }

    private AtomicInteger getCurrentVideoCount(String videoId) {
        return new AtomicInteger();
    }

    private void updateTopKVideo(String videoId, AtomicInteger curCount) {
        VideoCounter videoCounter = createVideoCounter(videoId, curCount);
        if (minHeap.size() < MaxK) {
            minHeap.add(videoCounter);
            return;
        }
        VideoCounter videoCounterMin = minHeap.peek();
        while (videoCounterMin.getViewCount().get() < curCount.get()) {
            minHeap.poll();
            minHeap.add(videoCounterMin);
        }

    }

    private VideoCounter createVideoCounter(String videoId, AtomicInteger curCount) {
        return null;
    }

    private VideoCountMessge createVideoMessage(String videoId) {
        return null;
    }

    @Override
    public List<String> findTopKVideo(int k) {
        return minHeap.stream().map(VideoCounter::getVideoId).toList();
    }


}
