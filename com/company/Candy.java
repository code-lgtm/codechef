package com.company;

/**
 * Created by kumar_garg on 5/5/15.
 * Problem statement can be found at https://www.hackerrank.com/challenges/candies
 */

public class Candy {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n = 3;
        int[] a = {1, 2, 2};
        int count = 0;
        int candy[] = new int[n];

        for(int i = 0 ; i < n ; i++)
        {
            candy[i] = 1;
        }

        for(int i = 1 ; i < n ; i++)
        {
            if(a[i] > a[i-1])
                candy[i] = candy[i-1]+1;
        }
        for(int i = n-1 ; i > 0 ; i--)
        {
            if(a[i] < a[i-1])
            {
                candy[i-1] = max(candy[i-1] , candy[i] + 1);
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            count = count +  candy[i] ;
        }
        System.out.println(count);
    }

    public static int max(int p , int q)
    {
        if(p > q)
            return p;
        else
            return q;
    }

}
