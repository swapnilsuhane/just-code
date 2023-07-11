package com.just.code.dsalgo.hashmap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.HashMap;

public class HashMapStoreToDisk {
    HashMap<Long, User> map = new HashMap<>();

    public void storeHashMap() {
        for (long i = 0; i < 1000_000_000; i++) {
            map.put(i, User.builder()
                    .name("swapnil")
                    .id(i)
                    .email("swapnil.suhane@gmail.com")
                    .phone("98999999")
                    .address("90 punggol central, 828722 singapore")
                    .dob("28041985").build());
        }
    }

    @Builder
    @RequiredArgsConstructor
    @AllArgsConstructor
    @Data
    static class User {
        String name;
        Long id;
        String email;
        String phone;
        String address;
        String dob;
    }

    public static void main(String[] args) {
        HashMapStoreToDisk hashMapStoreToDisk = new HashMapStoreToDisk();
        long startTime = Instant.now().toEpochMilli();
        hashMapStoreToDisk.storeHashMap();
        System.out.println("Time Taken MilliSec: " + (Instant.now().toEpochMilli() - startTime));
    }
}
