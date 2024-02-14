package com.just.code.dsalgo.company.walmart;

import java.util.ArrayList;
import java.util.List;

public class PathTraversal {
    static int n;
    static int[][] matrix;
    static List<List<int[]>> paths = new ArrayList<>();
    static int[][] move = new int[][] {{0,1}, {1,0}};

    /**
     * [1,1,0
     *  0,1,0
     *  1,1,1]
     *  paths =
     *  [{0,0},{0,1},]
     *
     *
     *
     *  start index=0,0, (n-1, n-1) end index
     *  move = right, down
     *
     *  n = 3
     *  x=0, y=0
     *  0,1, 1,0
     */

    public static List<List<int[]>> findAllPaths(int[][] mat) {
        n = mat.length;
        matrix = mat;
        helper(0, 0, new ArrayList<>());
        return paths;
    }

    private static void helper(int x, int y, List<int[]> path) {
        if(x < 0 || y < 0 || x >= n || y >= n || matrix[x][y] == 0){
            return;
        }
        //System.out.println(x + " - " + y);
        //bottom right
        if(x == n-1 &&  y == n-1) {
            List<int[]> temp = new ArrayList<>(path);
            temp.add(new int[]{x, y});
            //print(temp);
            paths.add(new ArrayList<>(temp));
            return;
        }
        for(int[] m : move) {
            List<int[]> temp = new ArrayList<>(path);
            temp.add(new int[]{x, y});
            helper(x+m[0], y+m[1], temp);
        }
    }

    /*
        0,0
     */

    public static void main(String[] args) {
        int[][] mat = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        List<List<int[]>> allPaths = findAllPaths(mat);
        System.out.println(allPaths.size());
        for(List<int[]> path : allPaths) {
            System.out.println(path.size());
            List<int[]> path1 = path;
            //for(int[] cor : path1) {
            for(int i=0; i<path1.size(); i++) {
                int[] cor = path1.get(i);
                System.out.print(" point: " + cor[0] + " " + cor[1]);
            }
            System.out.println();
        }
        /*
        [1,1,0
     *   0,1,0
     *   1,1,1]
     [00,01,11,21,22]
         */
    }

    static void print(List<int[]> p) {
        for(int[] cor : p) {
            System.out.print("print: " + cor[0] + " , " + cor[1]);
        }
        System.out.println();
    }
}
