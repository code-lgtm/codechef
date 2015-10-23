package com.company;

import java.util.Arrays;

/**
 * Created by kumar_garg on 6/22/15.
 */
public class Elfish {
    public static void main(String[] args)
    {
        System.out.println(elfish("tasteful"));

    }

    public static boolean elfish(String s)
    {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        return charPresent(arr, 'e', 0, arr.length - 1) &&
                charPresent(arr, 'l', 0, arr.length -  1) &&
                charPresent(arr, 'f', 0, arr.length - 1);

    }

    public static boolean charPresent(char arr[], char c, int start, int end)
    {
        if(start > end) return false;

        int mid = (start + end) / 2;
        if (arr[mid] == c) return true;
        else if (c < arr[mid]) return charPresent(arr, c, start, mid - 1);
        else return charPresent(arr, c, mid + 1, end);
    }
}
