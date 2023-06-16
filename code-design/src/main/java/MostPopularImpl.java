import java.util.*;

public class MostPopularImpl implements MostPopular {
    TreeMap<Integer, Set<Integer>> orderMap = new TreeMap<>();
    Map<Integer, Integer> freqMap = new HashMap<>();

    @Override
    public void increasePopularity(Integer contentId) {
        if(!freqMap.containsKey(contentId)) {
            freqMap.put(contentId, 1);
            orderMap.putIfAbsent(1, new HashSet<>());
            orderMap.get(1).add(contentId);
        } else {
            int prevPopu = freqMap.get(contentId);
            orderMap.get(prevPopu).remove(contentId);
            orderMap.putIfAbsent(prevPopu+1, new HashSet<>());
            orderMap.get(prevPopu+1).add(contentId);
            freqMap.put(contentId, prevPopu+1);
        }
    }
    @Override
    public Integer mostPopular() {
        if(orderMap.size()==0) return -1;
        Integer mostPopularKey = orderMap.firstKey();
        return orderMap.get(mostPopularKey).stream().findFirst().get();
    }

    @Override
    public void decreasePopularity(Integer contentId) { // [8,3] -> [8,2] - [8,1]
        if(freqMap.containsKey(contentId)) {
            int prevPopu = freqMap.get(contentId);
            int newPopular = prevPopu - 1;
            if(orderMap.get(prevPopu).size()==1) {
                orderMap.remove(prevPopu);
                if(newPopular==0) {
                    freqMap.remove(contentId);
                } else{
                    freqMap.put(contentId, newPopular);
                    orderMap.putIfAbsent(newPopular, new HashSet<>());
                    orderMap.get(newPopular).add(contentId);
                }
                return;
            }
            orderMap.get(prevPopu).remove(contentId);
            if(newPopular >0) {
                orderMap.putIfAbsent(newPopular, new HashSet<>());
                orderMap.get(newPopular).add(contentId);
                freqMap.put(contentId, newPopular);
            }
        }
    }
}

/**
 * Map<contentId, count> [7,2][8,3]
 * mostPopular -     -1 -> 8
 * heap -> [8,3][7,2]
 * 3 - [contentIds]
 * 2 - [contentIds]
 * TreeMap<Freq, <contentids> 3 ->
 *     2, [7]
 *     1, []
 *
 *
 * contentId value -> always +ve int
 * popularityTracker.increasePopularity(7); [7,1]
 *   popularityTracker.increasePopularity(7); [7,2]
 *   popularityTracker.increasePopularity(8); [7,2][8,1]
 *   popularityTracker.mostPopular();        // returns 7
 *   popularityTracker.increasePopularity(8); [7,2][8,2]
 *   popularityTracker.increasePopularity(8); [7,2][8,3]
 *   popularityTracker.mostPopular();        // returns 8
 *   popularityTracker.decreasePopularity(8); [7,2][8,2] -> any one
 *   popularityTracker.decreasePopularity(8); [7,2][8,1]
 *   popularityTracker.mostPopular();        // returns 7
 *   popularityTracker.decreasePopularity(7); [7,1][8,1]
 *   popularityTracker.decreasePopularity(7); [7,0][8,1] -> below 0 as no info so remove 7
 *   popularityTracker.decreasePopularity(8); []
 *   popularityTracker.mostPopular();        // returns -1 since
 */