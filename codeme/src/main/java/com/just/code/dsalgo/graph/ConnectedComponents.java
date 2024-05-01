package com.just.code.dsalgo.graph;

import java.util.*;

public class ConnectedComponents {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static Set<Integer> visited = new HashSet<>();
    public static void main(String[] args) {
        int[][] nums = new int[][] {{0,1},{1,2},{3,4},{1,3},{6,7},{8,9},{10,23}};
        int com =  findConnComponents(nums);
        System.out.println(com);
    }

    private static int findConnComponents(int[][] nums) {

        for(int[] n :  nums) {
            map.putIfAbsent(n[0], new ArrayList<>());
            map.putIfAbsent(n[1], new ArrayList<>());
            map.get(n[0]).add(n[1]);
            map.get(n[1]).add(n[0]);
        }

        int count =0;

        for(int key : map.keySet()) {
            if(!visited.contains(key)) {
                markComponent(key);
                count++;
            }
        }

        return count;
    }

    private static void markComponent(int key) {
        visited.add(key);
        if(map.containsKey(key)) {
            for(int ch : map.get(key)) {
                if(!visited.contains(ch))
                    markComponent(ch);
            }
        }
    }
}
