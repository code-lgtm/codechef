package com.company;

/**
 * Created by kumar_garg on 5/7/15.
 * DP Problem: Given an integer array. Find the length longest increasing sub sequence, 5 (10, 22, 33, 50, 60) in this
 * case
 */
public class LCS {
    public static void main(String[] args)
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println(lcs(arr));

    }

    private static int lcs(int[] a)
    {
        int lcs[] = new int[a.length];

        for (int i = 0; i < a.length; i++)
            lcs[i] = 1;

        for (int i = 1; i < lcs.length; i++)
        {
            for (int j= 0; j < i; j++) {
                if (a[i] > a[j] && lcs[i] < lcs[j] + 1)
                    lcs[i] = lcs[j] + 1;
            }
        }

        int max = lcs[0];
        for (int i = 1; i < lcs.length; i++)
            if (lcs[i] > max)
                max = lcs[i];

        return max;

    }
}
