package com.company;

/**
 * Created by kumar_garg on 6/1/2015.
 * Given a column title as appears in an Excel sheet, return its corresponding column number. Example:
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 */
public class ExcelColumnNumber {
    public static int titleToNumber(String A) {
        char[] charArr = A.toCharArray();
        int num = 0;
        int index = 1;

        for(int i = charArr.length-1; i >= 0; i--) {
            num = num + (charArr[i] - 'A'  + 1) * index;
            index = index * 26;
        }

        return num;
    }

    public static void main(String[] args)
    {
        System.out.println(titleToNumber("AA"));
    }
}
