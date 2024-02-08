package Array;

// leetcode 560 - Subarray Sum Equals K
// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// A subarray is a contiguous non-empty sequence of elements within an array.

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK
{
    public int subarraySum_PrefixSum(int[] nums, int k)
    {
        int total = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();
        prefixSums.put(0, 1);

        int sum = 0;

        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];

            int diff = sum-k;

            if (prefixSums.containsKey(diff))
                total += prefixSums.get(diff);

            prefixSums.put(sum, prefixSums.getOrDefault(sum, 0) + 1);
        }

         return total;
    }

    public int subarraySum_bruteForce(int[] nums, int k)
    {
        int total = 0;

        for (int i=0; i< nums.length; i++)
        {
            int currentSum = 0;

            for (int j=i; j<nums.length; j++)
            {
                currentSum += nums[j];

                if (currentSum == k)
                {
                    ++total;
                }
            }
        }

        return total;
    }

    @Test
    public void test()
    {
        assert (2 == subarraySum_bruteForce(new int[] {1,1,1}, 2));
        assert (2 == subarraySum_bruteForce(new int[] {1,2,3}, 3));
        assert (3 == subarraySum_bruteForce(new int[] {1,-1, 0}, 0));
        assert (4 == subarraySum_bruteForce(new int[] {1,-1,1,1,1,1}, 3));

        assert (2 == subarraySum_PrefixSum(new int[] {1,1,1}, 2));
        assert (2 == subarraySum_PrefixSum(new int[] {1,2,3}, 3));
        assert (3 == subarraySum_PrefixSum(new int[] {1,-1, 0}, 0));
        assert (4 == subarraySum_PrefixSum(new int[] {1,-1,1,1,1,1}, 3));
    }
}
