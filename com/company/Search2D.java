package com.company;

import java.util.ArrayList;
/**
 * Created by kumar_garg on 5/31/15.
 * http://www.interviewbit.com/courses/programming/topics/binary-search/problems/search2d/
 */
public class Search2D {
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> row1 = new ArrayList<Integer>();
        row1.add(1);
        row1.add(3);
        row1.add(5);
        row1.add(7);

        ArrayList<Integer> row2 = new ArrayList<Integer>();
        row2.add(10);
        row2.add(11);
        row2.add(16);
        row2.add(20);

        ArrayList<Integer> row3 = new ArrayList<Integer>();
        row3.add(23);
        row3.add(30);
        row3.add(34);
        row3.add(50);

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        System.out.println(isPresent(matrix, 49));
    }

    public static int isPresent(ArrayList<ArrayList<Integer>> A, int B)
    {
        int present = 0;
        int rowSize = A.get(0).size();
        int totalElem = A.size() * rowSize;
        int lo = 0;
        int hi = totalElem - 1;

        while(hi >= lo)
        {
            int middle = (hi + lo) / 2;
            int iIndex = middle / rowSize;
            int jIndex = middle % rowSize;

            int elem = A.get(iIndex).get(jIndex);
            if (B == elem) {
                present = 1;
                break;
            }
            else if (elem < B)
                lo = middle + 1;
            else
                hi = middle - 1;
        }

        return present;
    }
}
