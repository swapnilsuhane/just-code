package com.just.code.dsalgo.company.apple;

import java.util.*;
import java.util.stream.Collectors;

public class NoOfUniqueWords {

    public static int findNoOfUniqueWords(String str, List<String> delimiters) {
        Queue<String> queue = new LinkedList<>();
        queue.add(str);
        int p = 0;
        while(!queue.isEmpty() && p < delimiters.size()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String cur = queue.poll();
                Set<String> words = findUniqueWords(cur, delimiters.get(p));
                queue.addAll(words);
            }
            p++;
        }
        System.out.println(queue);
        return queue.size();
    }

    private static Set<String> findUniqueWords(String str, String delim) {
        if(str == null || str.isEmpty()) return new HashSet<>();
        String[] sa = str.split(delim);
        return Arrays.stream(sa).map(String::trim).filter(s -> !s.isEmpty()).collect(Collectors.toSet());
    }

    public static void main(String[] args) {
        System.out.println(findNoOfUniqueWords("red, red, green, white, #12321, hello..yellow", List.of("," , "\\.", "e", "o", "#", "3")));
    }
}

/*
"red, red, green, white, hello..yellow"


 */
