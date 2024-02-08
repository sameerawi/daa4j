package TwoPointers;

import org.junit.Test;

// leetcode 11 - Container With Most Water
// You are given an integer array height of length n.
// There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

import java.util.Arrays;

public class ContainerWithMostWater
{
    public int maxArea(int[] height)
    {
        int maxArea = Integer.MIN_VALUE;

        int left = 0, right = height.length-1;

        while (left < right)
        {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right-left) );

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }

    @Test
    public void test()
    {
        assert (49 == maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        assert (1 == maxArea(new int[]{1,1}));
    }
}
