package com.just.code.dsalgo.company.atlassian;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Map<CustId, {[1, 13:00:00], [2, 13:00:01],[1, 13:00:002}]
 * <p>
 * A -> 1 13:00:00
 * A -> 2 13:00:01
 * A -> 1 13:00:02
 * A -> 1 13:00:05
 * A -> 1 13:00:07
 * <p>
 * 13:00:04 now
 * <p>
 * LinkedList -> FIFO
 */
public class RateLimit {
    private static final long RATE_LIMIT = 1_00_000;
    private static final long NO_OF_SEC = 2;
    private static final Map<String, LinkedList<CustomerRequestDTO>> limitMap = new HashMap<>();

    public static boolean addRequest(String customerId) {
        ZonedDateTime now = getCurrentZdtInSeconds();
        removeExpiredRequests(customerId, now);
        limitMap.putIfAbsent(customerId, new LinkedList<>());
        LinkedList<CustomerRequestDTO> customerRequestDTOS = limitMap.get(customerId);
        CustomerRequestDTO customerRequestDTO = CustomerRequestDTO.builder().dateTime(now).requests(1).build();
        if (customerRequestDTOS.isEmpty()) {
            customerRequestDTOS.add(customerRequestDTO);
        } else {
            if (customerRequestDTOS.peekLast().dateTime.equals(now)) {
                customerRequestDTOS.peekLast().requests++;
            } else {
                customerRequestDTOS.add(customerRequestDTO);
            }
        }
        return true;
    }

    private static ZonedDateTime getCurrentZdtInSeconds() {
        return ZonedDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    // 13:06 -> 13:01 -> 13:00
    private static void removeExpiredRequests(String customerId, ZonedDateTime now) {
        LinkedList<CustomerRequestDTO> customerRequestDTOS = limitMap.get(customerId);
        ZonedDateTime timeShouldExpire = now.minusSeconds(NO_OF_SEC);
        while (!CollectionUtils.isEmpty(customerRequestDTOS) && customerRequestDTOS.peek().getDateTime().isBefore(timeShouldExpire)) {
            customerRequestDTOS.poll();
        }
        limitMap.put(customerId, customerRequestDTOS);
    }

    public static boolean isAllowed(String customerId) {
        ZonedDateTime now = getCurrentZdtInSeconds();
        removeExpiredRequests(customerId, now);
        LinkedList<CustomerRequestDTO> customerRequestDTOS = limitMap.get(customerId);
        AtomicLong totalRequests = new AtomicLong();
        customerRequestDTOS.stream().map(CustomerRequestDTO::getRequests).forEach(req -> totalRequests.addAndGet((long) req));
        boolean isAllowed = totalRequests.get() < RATE_LIMIT;
        System.out.println("isAllowed : " + isAllowed + " at :" + now + " limitMap: " + limitMap);
        return isAllowed;
    }


    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100000; i++) {
            String customerId = "swapnil";
            addRequest(customerId);
            //Thread.sleep(10);
            isAllowed(customerId);
        }

    }

    @RequiredArgsConstructor
    @AllArgsConstructor
    @Data
    @Builder
    static class CustomerRequestDTO {
        private int requests;
        private ZonedDateTime dateTime;
    }
}

/**
 * Map<CustId, {[1, 13:00:00], [2, 13:00:01],[1, 13:00:002}]
 * <p>
 * A -> 1 13:00:00
 * A -> 2 13:00:01
 * A -> 1 13:00:02
 * A -> 1 13:00:05
 * A -> 1 13:00:07
 * <p>
 * 13:00:04 now
 * <p>
 * LinkedList -> FIFO
 */
