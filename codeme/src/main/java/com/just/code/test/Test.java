package com.just.code.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> l1 = new ArrayList();
        l1.add(2);
        l1.add(6);
        l1.add(10);
        System.out.println(Collections.binarySearch(l1, 1));
        System.out.println(Collections.binarySearch(l1, 3));
        System.out.println(Collections.binarySearch(l1, 11));
        l1.add(0, 1);
        System.out.println(l1);
    }
}
