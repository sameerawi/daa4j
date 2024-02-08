package Array;

// leetcode 217 - Contains Duplicate

// Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate
{
    public boolean containsDuplicate_brute_force(int[] nums)
    {
        for (int i=0; i < nums.length; i++)
        {
            for(int j=i+1; j < nums.length; j++)
            {
                if (nums[i] == nums[j])
                    return true;
            }
        }

        return false;
    }

    public boolean containsDuplicate_optimized(int[] nums)
    {
        Set<Integer> set = new HashSet();

        for (int i=0; i < nums.length; i++)
        {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }

        return false;
    }

    @Test
    public void test()
    {
        assert (containsDuplicate_brute_force(new int[] {1,2,3,1}));
        assert (!containsDuplicate_brute_force(new int[] {1,2,3,4}));
        assert (containsDuplicate_brute_force(new int[] {1,1,1,3,3,4,3,2,4,2}));

        assert (containsDuplicate_optimized(new int[] {1,2,3,1}));
        assert (!containsDuplicate_optimized(new int[] {1,2,3,4}));
        assert (containsDuplicate_optimized(new int[] {1,1,1,3,3,4,3,2,4,2}));
    }
}
