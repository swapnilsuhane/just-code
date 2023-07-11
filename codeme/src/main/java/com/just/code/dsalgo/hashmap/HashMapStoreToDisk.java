package com.just.code.dsalgo.hashmap;

import com.just.code.dsalgo.common.serialize.ObjectSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashMap;

public class HashMapStoreToDisk {
    HashMap<Long, User> map = new HashMap<>();

    public void storeHashMap() {
        for (long i = 0; i < 1000_00; i++) {
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
    static class User implements Serializable {
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
        startTime = Instant.now().toEpochMilli();
        ObjectSerializer.writeObject(hashMapStoreToDisk.map);
        System.out.println(ObjectSerializer.readObject(hashMapStoreToDisk.map).size());
        System.out.println("Time Taken MilliSec: " + (Instant.now().toEpochMilli() - startTime));
    }

}
