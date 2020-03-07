package com.zipcodewilmington.arrayutility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility <E> {

    private E[] masterArray;
    private ArrayList<E> masterList;

    public ArrayUtility(E[] inputArray) {
        this.masterList = new ArrayList<E>(Arrays.asList(inputArray));
        this.masterArray = inputArray;
    }

    public E[] removeValue(Integer value) {
        masterList.remove(value);

    }

}
