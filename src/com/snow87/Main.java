package com.snow87;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        testAsciiStringSort();

//        testLongSort();


    }

    private static Random rando = new Random();

    private static String randomString() {
        int length = rando.nextInt((8 - 1) + 1) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char nextChar = (char) (rando.nextInt((126 - 32) + 1) + 32);
            sb.append(nextChar);
        }
        return sb.toString();
    }


    private static void testLongSort() {
        BobbertLongSort bbLS = new BobbertLongSort();
        List<Long> randoLongs = new ArrayList<>(1_000_000);

        for (int i = 0; i < 100_000_000; i++) {
            randoLongs.add(rando.nextLong());
        }

        compareSort(
                () -> bbLS.sort(randoLongs),
                () -> {
                    Collections.sort(randoLongs);
                    return randoLongs;
                });
    }

    private static void testAsciiStringSort() {
        BobbertAsciiStringSort bbSS = new BobbertAsciiStringSort();
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            data.add(randomString());
        }

        compareSort(
                () -> bbSS.sort(data),
                () -> {
                    Collections.sort(data);
                    return data;
                });

    }

    private static <T> void compareSort(Supplier<List<T>> bobbertSort, Supplier<List<T>> collectionsSort) {
        long rankSortTime = 0;
        long startTime = System.currentTimeMillis();
        List<T> bobbertSortResult = bobbertSort.get();
        rankSortTime += System.currentTimeMillis() - startTime;

        System.out.println("BobbertSort time: " + (rankSortTime));

        long collectionSortTime = 0;
        startTime = System.currentTimeMillis();
        List<T> collectionsSortResult = collectionsSort.get();
        collectionSortTime += System.currentTimeMillis() - startTime;
        System.out.println("Collection.sort time: " + (collectionSortTime));

        assert bobbertSortResult.size() == collectionsSortResult.size();
        for (int i = 0; i < bobbertSortResult.size(); i++) {
            if (!bobbertSortResult.get(i).equals(collectionsSortResult.get(i))) {
                throw new RuntimeException("list not sorted!");
            }
        }

    }
}
