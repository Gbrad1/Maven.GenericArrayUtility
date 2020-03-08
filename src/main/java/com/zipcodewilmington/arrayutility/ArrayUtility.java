package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <E> {

    private E[] masterArray;

    public ArrayUtility(E[] inputArray) {
        this.masterArray = inputArray;
    }

    public E[] removeValue(E value) {
        @SuppressWarnings("unchecked")
        E[] buffer = (E[]) Array.newInstance(value.getClass(), masterArray.length);
        int index = 0;

        for (int i = 0; i < masterArray.length; i++) {
            if (masterArray[i] != value) {
                buffer[index++] = masterArray[i];
            }
        }
        @SuppressWarnings("unchecked")
        E[] output = (E[]) Array.newInstance(value.getClass(), index);

        for (int i = 0; i < index; i++) {
            output[i] = buffer[i];
        }

        return output;
    }

    public Integer countDuplicatesInMerge(E[] arrayToMerge, E value) {
        int count = 0;

        for (E e : arrayToMerge) {
            if (e == value) {
                count++;
            }
        }

        for (E e : masterArray) {
            if (e == value) {
                count++;
            }
        }

        return count;
    }

    public E getMostCommonFromMerge(E[] arrayToMerge) {
        HashMap<E, Integer> map = new HashMap<>();

        for (int i = 0; i < masterArray.length; i++) {
            if (map.containsKey(masterArray[i])) {
                map.put(masterArray[i], map.get(masterArray[i]) + 1);
            } else
                map.put(masterArray[i], 1);
        }

        for (int i = 0; i < arrayToMerge.length; i++) {
            if (map.containsKey(arrayToMerge[i])) {
                map.put(arrayToMerge[i], map.get(arrayToMerge[i]) + 1);
            } else
                map.put(arrayToMerge[i], 1);
        }

        int value = 0;
        E key = null;

        for (Map.Entry<E, Integer> element : map.entrySet()) {
            if (element.getValue() > value) {
                value = element.getValue();
                key = element.getKey();
            }
        }
        return key;
    }

    public Integer getNumberOfOccurrences(E valueToEvaluate) {
        int count = 0;

        for (int i = 0; i < masterArray.length; i++) {
            if (masterArray[i] == valueToEvaluate) {
                count++;
            }
        }
        return count;
    }

}
