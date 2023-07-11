package com.just.code.dsalgo.company.atlassian;

import java.util.*;

public class MostPopularImpl implements MostPopular {
    //freq, set of contentIds
    TreeMap<Integer, Set<Integer>> orderMap = new TreeMap<>();
    //contentId, freq
    Map<Integer, Integer> contentCountMap = new HashMap<>();

    @Override
    public void increasePopularity(Integer contentId) {
        if (!contentCountMap.containsKey(contentId)) {
            contentCountMap.put(contentId, 1);
            orderMap.putIfAbsent(1, new HashSet<>());
            orderMap.get(1).add(contentId);
        } else {
            int lastPop = contentCountMap.get(contentId);
            int newPop = lastPop + 1;
            //remove last pop
            orderMap.get(lastPop).remove(contentId);
            clearMaps(contentId, lastPop);
            //add new pop
            orderMap.putIfAbsent(newPop, new HashSet<>());
            orderMap.get(newPop).add(contentId);
            //update content count
            contentCountMap.put(contentId, newPop);
        }
    }

    @Override
    public Integer mostPopular() {
        if (orderMap.size() == 0) return -1;
        Integer mostPopularKey = orderMap.lastKey();
        return orderMap.get(mostPopularKey).stream().findFirst().get();
    }

    @Override
    public void decreasePopularity(Integer contentId) { // [8,3] -> [8,2] - [8,1]
        if (contentCountMap.containsKey(contentId)) {
            int lastPop = contentCountMap.get(contentId);
            int newPop = lastPop - 1;
            //remove last pop
            orderMap.get(lastPop).remove(contentId);
            //update content count
            contentCountMap.put(contentId, newPop);
            clearMaps(contentId, lastPop);
            //add new pop only +ve
            if (newPop > 0) {
                orderMap.putIfAbsent(newPop, new HashSet<>());
                orderMap.get(newPop).add(contentId);
            }
        }
    }

    private void clearMaps(Integer contentId, Integer pop) {
        if (orderMap.containsKey(pop) && orderMap.get(pop).size() == 0) {
            orderMap.remove(pop);
        }
        if (contentCountMap.containsKey(contentId) && contentCountMap.get(contentId) == 0) {
            contentCountMap.remove(contentId);
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
 * 2, [7]
 * 1, []
 * <p>
 * <p>
 * contentId value -> always +ve int
 * popularityTracker.increasePopularity(7); [7,1]
 * popularityTracker.increasePopularity(7); [7,2]
 * popularityTracker.increasePopularity(8); [7,2][8,1]
 * popularityTracker.mostPopular();        // returns 7
 * popularityTracker.increasePopularity(8); [7,2][8,2]
 * popularityTracker.increasePopularity(8); [7,2][8,3]
 * popularityTracker.mostPopular();        // returns 8
 * popularityTracker.decreasePopularity(8); [7,2][8,2] -> any one
 * popularityTracker.decreasePopularity(8); [7,2][8,1]
 * popularityTracker.mostPopular();        // returns 7
 * popularityTracker.decreasePopularity(7); [7,1][8,1]
 * popularityTracker.decreasePopularity(7); [7,0][8,1] -> below 0 as no info so remove 7
 * popularityTracker.decreasePopularity(8); []
 * popularityTracker.mostPopular();        // returns -1 since
 */