package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Created by kumar_garg on 8/22/15.
 */
public class PoisonousPlants {
    public static int count(long a[]) {
        int i = 0;
        int count = 0;

        while (i < a.length - 1) {
            ArrayList<Integer> indexes = new ArrayList<Integer>();

            while (i < a.length - 1 && a[i + 1] <= a[i]) i++;
            if (i >= a.length-1) break;
            indexes.add(i++);

            while (true) {
                while (i < a.length - 1 && a[i + 1] > a[i]) i++;
                if (i < a.length - 1 && a[i + 1] <= a[i]) {
                    if (a[i + 1] > a[indexes.get(0)]) {
                        boolean small = true;

                        if (indexes.size() > 1 && a[i+1] > a[indexes.get(indexes.size()-1)]) small = false;
                        if (small) {
                            indexes.add(i + 1);
                        }
                    }
                    else break;
                }
                i++;
                if (i >= a.length-1) break;
            }
            count =  indexes.size() > count ? indexes.size() : count;
            i++;
        }
        return count;
    }

    public static void main(String[] args)
    {
        //int a[] = {6, 5, 4, 10, 8, 9, 12, 10, 9, 10, 4}; //Ans : 3
        //int a[] = {6, 5, 4, 10, 8, 9, 10, 8, 9, 10, 4}; //Ans:3
        //int a[] = {5, 4, 3, 2}; //Ans: 0
        //int a[] = {6, 5, 8, 4, 7, 10, 9}; //Ans:2
        //int a[] = {2, 3, 4, 5}; //Ans:1
        //int a[] = {5,5,5,5,5};
        //int a[] = {11, 7, 19, 6, 12, 12, 8, 8, 7, 1, 10, 15, 5, 12}; //Ans:5
        //long a[] = {641549257, 2954006, 255838155, 609592985, 932285899, 681377753, 178566992, 140762879, 67690131,
                //649165648, 103080948, 48130257, 116856252, 202957200, 690590736, 402349689, 12685461};
        long a[] = {5, 6, 7, 4, 5,  6, 7, 5};
        System.out.println(count(a));

//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("/Users/kumar_garg/Desktop/input.txt"));
//            int arr_size = Integer.parseInt(reader.readLine());
//            long a[] = new long[arr_size];
//            String str = reader.readLine();
//            String[] arr_elements = str.split(" ");
//            for(int i = 0; i < arr_size; i++)
//            {
//                a[i] = Integer.parseInt(arr_elements[i]);
//            }
//
//            /*for(int i = 63; i < 332; i++)
//            {
//                System.out.print(a[i] + " ");
//            }*/
//
//            System.out.println(count(a));
//        } catch(Exception e) {e.printStackTrace();}
    }
}

/*
* 6 5 4 6 5
*     k i
* 6 5 4 6 4
*     k i
* 6 5 4 10 8 9 10 9 9 10 4
*     k
*
*     6 5 4 10 8 9 10 9 9 10 4
*     6 5 4 8 9 9 4
*     6 5 4 9 4
*     6 4 4 4
*
*     6 5 4 10 8 9 10 8 9 10 4
*     6 5 4 8 8 4
*     6 5 4 8 4
*     6 5 4 4
*
*     6 5 4 10 8 9 12 10 9 10 4
*     6 5 4 8 10 9 4
*     6 5 4 9 4
*     6 5 4 4
*
*     6 5 4 10 8 9 12 7 9 10 4
*/