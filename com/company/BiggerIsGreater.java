package com.company;

import java.util.Arrays;

/**
 * Created by kumar_garg on 5/16/15.
 * Problem statement can be found at https://www.hackerrank.com/challenges/bigger-is-greater
 */
public class BiggerIsGreater {
    public static void main(String[] args)
    {

        String s9 ="yzijsdolrovfjazwzbcreipdqgkopxwwtrtzaomiliixygufejysbwsbgxkkdgjgsubxyfnozecvczyckrqcndglreuxixdrhg";

        char[] cArr = s9.toCharArray();
        int arrLength = cArr.length;
        int maxI = -1;
        int maxJ = -1;

        boolean answerFound = false;

        outer: for (int i = arrLength - 1 ; i > 0 && i > maxJ; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (cArr[i] > cArr[j]) {
                    if (j > maxJ) { maxI = i; maxJ = j;}
                    answerFound = true;

                    break;
                }
            }
        }

        if (!answerFound) System.out.println("No answer");
        else {
            char tmp = cArr[maxI];

            cArr[maxI] = cArr[maxJ];
            cArr[maxJ] = tmp;
            Arrays.sort(cArr, maxJ + 1, arrLength);

            System.out.println(new String(cArr));
        }
    }
}