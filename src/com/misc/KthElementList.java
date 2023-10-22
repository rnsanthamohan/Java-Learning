package com.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

public class KthElementList {

    public static int findKthElement(List<Integer> list, int k) {
        int result = -1;
        if (list != null) {
            Collections.sort(list);
            result = list.get(k-1);
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        List<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(10);
        list.add(4);
        list.add(3);
        list.add(20);
        list.add(15);
        int result = KthElementList.findKthElement(list, 3);
        System.out.println(result);
    }
}
