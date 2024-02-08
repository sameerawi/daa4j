package Array;

// leetcode 215 - Kth Largest Element in an Array - Quick Select
// Given an integer array nums and an integer k, return the kth largest element in the array.


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KthLargestElement
{
    public int findKthLargest_quickSelect(int[] nums, int k)
    {
        // todo :

        return 0;
    }

    @Test
    public void test()
    {
        assert (5 == findKthLargest_quickSelect(new int[] {3,2,1,5,6,4}, 2));
        assert (4 == findKthLargest_quickSelect(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
