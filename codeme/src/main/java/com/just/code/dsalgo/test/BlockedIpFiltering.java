package com.just.code.dsalgo.test;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class BlockedIpFiltering {

    static Map<String, LinkedList<Integer>> unblocked = new HashMap<>();

    /*
     * Complete the 'validateRequests' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY blacklisted_ips
     *  2. STRING_ARRAY requests
     */

    public static List<Integer> validateRequests(List<String> blacklisted_ips, List<String> requests) {
        List<Integer> isBlocked = new ArrayList<>();
        List<String> blacklistedRegexList = convertToRegex(blacklisted_ips);
        for (int i = 0; i < requests.size(); i++) {
            String reqIP = requests.get(i);
            //blocked ip request
            if (blocked(blacklistedRegexList, reqIP)) {
                isBlocked.add(1);
            } else {
                unblocked.putIfAbsent(reqIP, new LinkedList<>());
                LinkedList<Integer> unblockedList = unblocked.get(reqIP);
                while (unblockedList != null && !unblockedList.isEmpty() && unblockedList.peek() <= i - 5) {
                    unblockedList.poll();
                }
                if (unblockedList != null && !unblockedList.isEmpty() && unblockedList.size() >= 2) {
                    isBlocked.add(1);
                } else {
                    isBlocked.add(0);
                }
                unblocked.get(reqIP).add(i);
            }
        }
        return isBlocked;
    }

    private static List<String> convertToRegex(List<String> blacklistedIps) {
        List<String> regexList = new ArrayList<>(blacklistedIps.size());
        for (String bip : blacklistedIps) {
            if (bip.contains("*")) {
                int i = bip.indexOf("*");
                int leftDots = 0, rightDots = 0;
                for (int j = 0; j < i; j++) {
                    if (bip.charAt(j) == '.') {
                        leftDots++;
                    }
                }
                for (int j = i + 1; j < bip.length(); j++) {
                    if (bip.charAt(j) == '.') {
                        rightDots++;
                    }
                }
                //not full ipv4 format ex 1.2.3.4
                StringBuilder regex = new StringBuilder(bip);
                if (leftDots + rightDots < 3) {
                    if (leftDots < rightDots) {
                        while (leftDots + rightDots < 3) {
                            regex.insert(0, "*.");
                            leftDots++;
                        }
                    } else {
                        while (leftDots + rightDots < 3) {
                            regex.append(".*");
                            rightDots++;
                        }
                    }
                }
                regexList.add(regex.toString());
            } else {
                regexList.add(bip);
            }
        }
        String zeroTo255_Regex = "\\\\d?\\\\d?\\\\d?";
        return regexList.stream().map(r -> r.replaceAll("\\*", zeroTo255_Regex)).collect(Collectors.toList());
    }

    private static boolean blocked(List<String> blockedIPRegexList, String req) {
        for (String regex : blockedIPRegexList) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(req);
            if (matcher.matches()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        List<String> blacklistedIps = List.of("121.*","34*","123.23.83.235", "123.23.*.234");
        List<String> requestedIps = List.of("126.23.83.234","121.23.83.234","121.23.83.234",
                "126.23.83.234","123.23.83.234","121.23.83.234","126.23.83.234");
        List<Integer> isBlocked = validateRequests(blacklistedIps, requestedIps);
        System.out.println(isBlocked);
    }
}

