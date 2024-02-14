package com.just.code.dsalgo.company.walmart;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {
    public static List<int[]> getTwoSum(int[] ar, int target) {
        Set<Integer> set = new HashSet();
        List<int[]> list = new ArrayList<>();
        for(int n : ar) {
            int rem = target - n;
            if(set.contains(rem)) {
                list.add(new int[]{n, rem});
            }
            set.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] ar = new int[]{1,5,5,2,3,7,4,10,4};
        List<int[]> list = getTwoSum(ar, 8);
        for(int[] val : list)
            System.out.println(val[0] + ", " + val[1]);
    }


}
