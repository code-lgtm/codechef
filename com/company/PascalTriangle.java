package com.company;

import java.util.ArrayList;

/**
 * Created by kumar_garg on 6/1/2015.
 * Problem: http://www.interviewbit.com/courses/programming/topics/arrays/problems/pascal2/
 */
public class PascalTriangle {
    public static void main(String[] args)
    {
        ArrayList<Integer> row = genRow(0);

        for (Integer i : row)
            System.out.print(i + " ");
    }

    private static ArrayList<Integer> genRow(int k)
    {
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>(k + 1);
        for (int i = 0; i < k + 1; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();

            triangle.add(i, row);
        }


        triangle.get(0).add(1);

        if(k == 0) return triangle.get(k);
        triangle.get(1).add(1);
        triangle.get(1).add(1);

        for (int i = 2; i < k+1; i++)
        {
            triangle.get(i).add(1);
            for (int j = 1; j < triangle.get(i-1).size(); j++)
            {
                triangle.get(i).add(triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j));
            }
            triangle.get(i).add(1);
        }

        return triangle.get(k);
    }
}
