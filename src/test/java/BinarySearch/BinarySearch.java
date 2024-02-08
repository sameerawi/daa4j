package BinarySearch;

// leetcode 704 - Binary Search
// Given an array of integers nums which is sorted in ascending order, and an integer target,
// write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

import org.junit.Test;

import java.util.Arrays;

public class BinarySearch
{
    public int search(int[] nums, int target)
    {
        int l = 0, r = nums.length-1;

        while (l < r)
        {
            int middle = l + (r - l) / 2;

            if (nums[middle] > target)
            {
                r = middle-1;
            }
            else if(nums[middle] < target)
            {
                l = middle+1;
            }
            else
                return middle;
        }

        return -1;
    }

    @Test
    public void test()
    {
        assert (4 == search(new int[] {-1,0,3,5,9,12}, 9));
        assert (4 == search(new int[] {-1,0,3,5,9,12}, 9));
    }
}
