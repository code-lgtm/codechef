package com.company;

/**
 * Created by kumar_garg on 6/1/2015.
 * Problem: Make all the elements of a row and column as zero if any element in that row or coulmn is zero
 */
public class MakeZeroMatrix {
    public static void main(String[] args)
    {
        int[][] matrix = {
                {4, 0, 5, 1},
                {3, 6, 5, 8},
                {4, 7, 0, 9},
                {1, 8, 1, 5}
        };

        genZeroMatrix(matrix);

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void genZeroMatrix(int[][] matrix)
    {
        boolean row[] = new boolean[matrix.length];
        boolean column[] = new boolean[matrix[0].length];

        for (int i = 0; i < row.length; i++)
        {
            for (int j = 0; j < column.length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++)
            if (row[i])
                for (int j = 0; j < column.length; j++)
                    matrix[i][j] = 0;

        for (int j = 0; j < column.length; j++)
            if (column[j])
                for (int i = 0; i < row.length; i++)
                    matrix[i][j] = 0;
    }
}
