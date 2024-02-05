package com.just.code.dsalgo.company.tittok;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AppLogsParser {
    private static final String COLON_SEPARATOR = ":";
    private static final String EQUAL_SEPARATOR = "=";
    private static final String SERVICE_KEY = "service";
    private static final String LOG_KEY = "level";

    public static Map<String, Map<String, AtomicInteger>> getServiceLogCounts(String[] logs) {
        Map<String, Map<String, AtomicInteger>> map = new HashMap<>();
        //"timestamp=100:level=error:service=shark:msg=initialization failed",
        for (String log : logs) {
            List<String> keys = Stream.of(log.split(COLON_SEPARATOR)).toList();
            Map<String, String> keyMap = keys.stream().map(key -> Arrays.stream(key.split(EQUAL_SEPARATOR)).toList())
                    .collect(Collectors.toMap(v -> v.get(0), v -> v.get(1)));
            String service = keyMap.get(SERVICE_KEY);
            String logType = keyMap.get(LOG_KEY);
            if (service != null && logType != null) {
                map.putIfAbsent(service, new HashMap<>());
                map.get(service).putIfAbsent(logType, new AtomicInteger(0));
                map.get(service).get(logType).getAndIncrement();
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String[] logs = new String[]{"timestamp=100:level=error:service=shark:msg=initialization failed",
                "timestamp=100:level=error:service=shark:msg=initialization failed",
                "timestamp=100:level=info:service=shark:msg=initialization failed",
                "timestamp=100:level=warn:service=shark:msg=initialization failed",
                "timestamp=100:level=error:service=rss:msg=initialization failed",
                "timestamp=100:level=error:service=shark:msg=initialization failed",
                "timestamp=100:level=info:service=rss:msg=initialization failed",
                "timestamp=100:level=info:service=app:msg=initialization failed"};
        System.out.println(getServiceLogCounts(logs));
    }
}
