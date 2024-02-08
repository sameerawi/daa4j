package Array;

// leetcode 1 - Two Sum
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum
{
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer, Integer> cache = new HashMap<>();

        for (int i=0; i<nums.length; i++)
        {
            Integer val = cache.get(nums[i]);
            if (val != null)
                return new int[] { val, i };
            else
                cache.put(target-nums[i], i);
        }

        return new int[]{};
    }

    @Test
    public void test()
    {
        assert (Arrays.equals( new int[] {0,1} , twoSum(new int[] {2,7,11,15}, 9)));
        assert (Arrays.equals( new int[] {1,2} , twoSum(new int[] {3,2,4}, 6)));
        assert (Arrays.equals( new int[] {0,1} , twoSum(new int[] {3,3}, 6)));
    }
}
