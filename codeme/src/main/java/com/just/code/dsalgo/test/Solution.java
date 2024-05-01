package com.just.code.dsalgo.test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public void test(User u) {
        u.name = "neha";
        System.out.println("fdsf");
    }

    public static void main(String[] args) {
        User user = new User();
        Solution s = new Solution();
        s.test(user);
        user.name = "reyom";
        System.out.println(user.name);
        Integer[] ar = new Integer[5];

        String str = "1_2";


    }

}
class User {
    String name = "swapnil";
}
