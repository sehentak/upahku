package com.sehentak.product.upahku;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {
//    val a = arrayListOf(1, 2, 3)
//    val b = arrayListOf(2, 5)

    public static int[] mergeArray(int[] A, int[] B) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int value : A) { list.add(value); }
        for (int value : B) { list.add(value); }

        int[] result = new int[list.size()];
        int i = 0;
        for (Integer value : list) {
            result[i++] = value;
        }
        Arrays.sort(result);
        return result;
    }
}
