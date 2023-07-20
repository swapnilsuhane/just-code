package com.just.code.dsalgo.company.amazon;

import java.util.ArrayList;
import java.util.List;

public class ShortestPathsToGate {
    public int[][] findPaths(int[][] grid) {
        List<List<Integer>> gates = new ArrayList<>();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid.length; j++) {
                //gate
                if(grid[i][j] == 0){
                    gates.add(List.of(i, j));
                }
            }
        }
        for(List<Integer> gate : gates)
            findShortestPathBST(grid, gate.get(0), gate.get(1));

        return grid;
    }

    private void findShortestPathBST(int[][] grid, Integer x, Integer y) {

    }

    private void print(int[][] grid) {
        for(int[] row : grid)
            for(int col : row) {
                System.out.print(col+ ", ");
            }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer INF = Integer.MAX_VALUE;
        int[][] grid = new int[][] {{INF, -1, 0, INF},
                                    {INF, INF, INF, INF},
                                    {INF, INF, INF, INF},
                                    {0, INF, -1, INF}};
        ShortestPathsToGate shortestPathsToGate = new ShortestPathsToGate();
        int[][] paths = shortestPathsToGate.findPaths(grid);
        shortestPathsToGate.print(paths);
    }
}
