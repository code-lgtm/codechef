package com.company;

import java.util.ArrayList;

/**
 * Created by kumar_garg on 5/31/15.
 * Problem: http://www.interviewbit.com/courses/programming/topics/arrays/problems/prettyprint/
 */
public class PrettyMatrix {
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> matrix1 = genMatrix(4);

        for (ArrayList<Integer> array : matrix1)
        {
            for (Integer i : array)
                System.out.print(i + " ");

            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> genMatrix(int A)
    {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(2*A-1);

        for (int i = 0; i < 2 * A -1 ; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>(2 * A - 1);

            for (int j = 0; j < 2 * A - 1; j++) {
                row.add(j, 0);
            }

            matrix.add(i, row);
        }

        int num = A;
        for (int i = 0, j = 2 * A - 2; i <= j; i++, j--) {
            for (int k = i; k <= j; k++) {
                matrix.get(i).set(k, num);
                matrix.get(j).set(k, num);
                matrix.get(k).set(i, num);
                matrix.get(k).set(j, num);
            }

            num--;
        }

        return  matrix;
    }
}
