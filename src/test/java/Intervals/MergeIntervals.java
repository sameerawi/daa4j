package Intervals;

// leetcode 56 - Merge Intervals
// Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
// and return an array of the non-overlapping intervals that cover all the intervals in the input.

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals
{
    public int[][] merge(int[][] intervals)
    {
        List<int[]> merged = new ArrayList<>();

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]) );

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1; i<intervals.length; i++)
        {
            if ( intervals[i][0] < end)
                end = intervals[i][1];
            else
            {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        merged.add(new int[]{start, end});

        return (int[][]) merged.toArray();
    }


    @Test
    public void test()
    {
        assert(Arrays.deepEquals(merge(new int[][]{ {1,3},{2,6},{8,10},{15,18} }), new int[][] {{1,6},{8,10},{15,18}} ) );
        assert (Arrays.deepEquals(merge(new int [][] {{1,4},{4,5}}), new int[][] {{1,5}}));
    }
}
