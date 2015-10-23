package com.company;

/**
 * Created by kumar_garg on 8/16/15.
 */

import java.io.*;

public class Moist {
    public static int insertionSort(String a[])
    {
        int cost = 0;

        for(int i = 1; i < a.length; i++)
        {
            boolean init = false;
            for(int j = i; j > 0; j--)
            {
                if(a[j].compareTo(a[j-1]) < 0)
                {
                    String temp = a[j-1];

                    a[j-1] = a[j];
                    a[j] = temp;
                    init = true;
                }
            }

            if (init)
                cost++;
        }

        return cost;
    }

    public static void main(String[] args)
    {
        try {
            BufferedReader in = new
                    BufferedReader(new FileReader("/Users/kumar_garg/Desktop/moist/C-small-practice-2.in"));
            PrintWriter writer = new
                    PrintWriter(new BufferedWriter(new FileWriter("/Users/kumar_garg/Desktop/moist/output.txt")));

            int T = Integer.parseInt(in.readLine());

            for(int t = 0; t < T; t++)
            {
                int N = Integer.parseInt(in.readLine());
                String arr[] = new String[N];

                for (int n = 0; n < N; n++)
                {
                    arr[n] = in.readLine();
                }

                int cost = insertionSort(arr);

                String outputStr = "Case #" + (t + 1) + ": " + cost;
                writer.write(outputStr, 0, outputStr.length());
                writer.write("\n");
            }

            in.close();
            writer.close();

        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
