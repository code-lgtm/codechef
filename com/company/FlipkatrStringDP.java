package com.company;

import java.util.HashSet;

/**
 * Created by kumar_garg on 5/21/15.
 */
public class FlipkatrStringDP {
    public static void main(String[] args)
    {
        HashSet<String> set = new HashSet<String>();
        set.add("I");
        set.add("am");
        set.add("a");
        set.add("programmer");
        String s = "Iam aprog ram mer";

        System.out.println(canFromSentence(set, s));

    }

    public static boolean canFromSentence(HashSet<String> set, String src)
    {
        boolean present = false;
        String s = src.replace(" ", "");

        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i; i < s.length(); j++)
            {

            }
        }


        return present;
    }
}
