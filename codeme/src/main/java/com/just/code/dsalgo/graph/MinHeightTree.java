package com.just.code.dsalgo.graph;

import java.util.*;

//https://leetcode.com/problems/minimum-height-trees/description/
public class MinHeightTree {
    static Map<Integer, List<Integer>> adj;
    static Map<Integer, Integer> heightMap = new HashMap<>();
    static List<Integer> mhtList = new ArrayList<>();
    static Set<Integer> visited = new HashSet<>();
    static int minHeight = Integer.MAX_VALUE;

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        adj = createAdjList(edges);
        visited.add(0);
        dfs(0);
        return mhtList;
    }

    private static int dfs(int e) {
        int h =0;
        if(adj.containsKey(e)) {
            for(int ch : adj.get(e)) {
                if(!visited.contains(ch)) {
                    visited.add(ch);
                    h = dfs(ch) + 1;
                } else {
                    h = 0;
                }
            }
        }
        heightMap.put(e, h);
        return h;
    }


    private static Map<Integer, List<Integer>> createAdjList(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges) {
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.putIfAbsent(edge[1], new ArrayList<>());
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
        List<Integer> minHeightTrees = findMinHeightTrees(n, edges);
        System.out.println(minHeightTrees);
        //Output: [3,4]
    }
}
