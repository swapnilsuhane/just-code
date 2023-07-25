package com.just.code.dsalgo.company.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
-1 = wall
0 = gate
INF = empty room
Given grid fine the shortest path from any gate
INF, -1,  0,   INF
INF, INF, INF, INF
INF, INF, INF, INF
0,   INF, -1,  INF
 */
public class ShortestPathsToGate {
    public int[][] findPaths(int[][] grid) {
        List<List<Integer>> gates = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //gate
                if (grid[i][j] == 0) {
                    gates.add(List.of(i, j));
                }
            }
        }
        for (List<Integer> gate : gates)
            findShortestPathBST(grid, gate.get(0), gate.get(1));

        return grid;
    }

    private void findShortestPathBST(int[][] grid, Integer x, Integer y) {
        Queue<GridNode> qu = new LinkedList<>();
        int[][] moves = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        qu.add((new GridNode(x, y, 0)));
        visited[x][y] = true;
        while (!qu.isEmpty()) {
            GridNode node = qu.poll();
            for (int[] move : moves) {
                int iNew = node.i + move[0];
                int jNew = node.j + move[1];
                if (iNew >= 0 && jNew >= 0 && iNew < grid.length && jNew < grid[0].length && !visited[iNew][jNew] &&
                        grid[iNew][jNew] > 0) { //skip wall & gate
                    qu.add(new GridNode(iNew, jNew, node.len + 1));
                    grid[iNew][jNew] = Math.min(grid[iNew][jNew], node.len + 1);
                    visited[iNew][jNew] = true;
                }
            }
        }
    }

    private void print(int[][] grid) {
        for (int[] row : grid) {
            for (int col : row) {
                System.out.print(col + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int INF = Integer.MAX_VALUE;
        int[][] grid = new int[][]{{INF, -1, 0, INF},
                {INF, INF, INF, INF},
                {INF, INF, INF, INF},
                {0, INF, -1, INF}};
        ShortestPathsToGate shortestPathsToGate = new ShortestPathsToGate();
        int[][] paths = shortestPathsToGate.findPaths(grid);
        shortestPathsToGate.print(paths);
    }

    static class GridNode {
        int i;
        int j;
        int len;

        GridNode(int i, int j, int len) {
            this.i = i;
            this.j = j;
            this.len = len;
        }
    }
}
