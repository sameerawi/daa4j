package Heap;

// leetcode 703 - Kth Largest Element in a Stream

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream
{
    public class KthLargest
    {
        int k;
        Queue<Integer> pq = new PriorityQueue();

        public KthLargest(int k, int[] nums)
        {
            this.k = k;

            for(int i : nums)
                pq.offer(i);
        }

        private void evict()
        {
            while (pq.size() > k)
                pq.poll();
        }

        public int add(int val)
        {
            pq.offer(val);

            evict();

            return pq.peek();
        }
    }


    @Test
    public void test()
    {
        KthLargest k = new KthLargest(3, new int[]{4, 5, 8, 2});
        assert ( 4 == k.add(3));
        assert ( 5 == k.add(5));
        assert ( 5 == k.add(10));
        assert ( 8 == k.add(9));
        assert ( 8 == k.add(4));
    }
}
