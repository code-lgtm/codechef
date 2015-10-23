package com.company;

import java.util.ArrayList;

/**
 * Created by kumar_garg on 6/1/2015.
 * Problem:
 * rotate the array A by B positions.
 * So, for example,
 * A : [1 2 3 4 5 6]
 * B : 1
 * The output :
 * [2 3 4 5 6 1]
 */
public class RotateArray {
    public static ArrayList<Integer> rotateArray(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < A.size(); i++) {
            ret.add(A.get((i + B) % A.size()));
        }
        return ret;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> input = new ArrayList<Integer>(6);
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        input.add(5);
        input.add(6);

        ArrayList<Integer> output = rotateArray(input, 1);

        for (Integer i : output)
            System.out.print(i + " ");
    }
}
