package com.company;

import java.io.*;
import java.util.HashSet;

/**
 * Created by kumar_garg on 4/16/15.
 * Problem statement can be found at location
 * https://code.google.com/codejam/contest/90101/dashboard
 */
public class Alien {
    public static void main(String[] args)
    {
        try
        {
            BufferedReader in = new
                    BufferedReader(new FileReader("/Users/kumar_garg/Desktop/A-large-practice.in"));
            PrintWriter writer = new
                    PrintWriter(new BufferedWriter(new FileWriter("/Users/kumar_garg/Desktop/output.txt")));

            String[] problemSize = in.readLine().split(" ");
            int L = Integer.parseInt(problemSize[0]);
            int D = Integer.parseInt(problemSize[1]);
            int N = Integer.parseInt(problemSize[2]);

            String[] dict = new String[D];
            for (int i = 0; i < D; i++)
                dict[i] = in.readLine();

            for (int i = 0; i < N; i++)
            {
                int k = 0;
                boolean start = false;
                String testcase = in.readLine();
                HashSet<Character>[] destSet = new HashSet[L];

                for (int j = 0; j < L; j++)
                    destSet[j] = new HashSet<Character>();

                for (int z = 0; z < testcase.length(); z++)
                {
                    char c = testcase.charAt(z);

                    if(c == '(') { start = true; }
                    else if (c == ')')  { start = false; k++; }
                    else  {
                        if (start) destSet[k].add(c);
                        else destSet[k++].add(c);
                    }
                }

                int count = 0;
                for (int j = 0; j < D; j++)
                {
                    char[] dictEntry = dict[j].toCharArray();
                    boolean matchFound = true;

                    for (int l = 0; l < dictEntry.length; l++)
                    {
                        if (!destSet[l].contains(dictEntry[l]))
                            matchFound = false;
                    }

                    if (matchFound) count++;
                }

                String outputStr = "Case #" + (i + 1) + ": " + count;
                writer.write(outputStr, 0, outputStr.length());
                writer.write("\n");
            }

            in.close();
            writer.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
