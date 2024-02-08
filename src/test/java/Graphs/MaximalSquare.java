package Graphs;

// leetcode 221 - Maximal Square
// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

import org.junit.Test;

public class MaximalSquare
{
    public int maximalSquare(char[][] matrix)
    {
        int max = 0;

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                int currentMax = 0;

                int right = travelRight(matrix, i, j);
                int down = travelDown(matrix, i, j);
                int diagonal = travelDiagonal(matrix, i, j);

                currentMax = Math.min(Math.min(right, down), diagonal);

                max = Math.max(currentMax, max);
            }
        }

        return max*max;
    }

    int travelRight(char[][] matrix, int r, int c)
    {
        int count = 0;
        while (r < matrix.length && c < matrix[r].length )
        {
            if (matrix[r][c] == '1')
                ++count;
            else
               break;

            c++;
        }

        return count;
    }

    int travelDown(char[][] matrix, int r, int c)
    {
        int count = 0;
        while (r < matrix.length && c < matrix[r].length )
        {
            if (matrix[r][c] == '1')
                ++count;
            else
                break;

            r++;
        }

        return count;
    }

    int travelDiagonal(char[][] matrix, int r, int c)
    {
        int count = 0;
        while (r < matrix.length && c < matrix[r].length )
        {
            if (matrix[r][c] == '1')
                ++count;
            else
                break;

            r++;
            c++;
        }

        return count;
    }

    @Test
    public void test()
    {
        char[][] test1 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        assert (4 == maximalSquare(test1));

        char[][] test2 = {{'0','1'},{'1','0'}};
        assert (1 == maximalSquare(test2));
    }
}
