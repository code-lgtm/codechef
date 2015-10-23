package com.company;

/**
 * Created by kumar_garg on 5/7/15.
 * Problem statement can be found at http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 */
public class LCS2 {
    static int lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];
        int i, j;

   /* Following steps build L[m+1][n+1] in bottom up fashion. Note
      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (i=0; i<=m; i++)
        {
            for (j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;

                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }

   /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
        return L[m][n];
    }

    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        System.out.println(lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length()));
    }
}
