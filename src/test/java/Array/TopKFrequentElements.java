package Array;

// leetcode 347 - Top K Frequent Elements
// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

import org.junit.Test;

import java.util.*;

public class TopKFrequentElements
{
    public Map<Integer, Integer> countOccurrences(int[] nums)
    {
        Map<Integer, Integer> items = new HashMap<>();

        for (int num : nums)
        {
            items.put(num, items.getOrDefault(num, 0)+1 );
        }

        return items;
    }

    public int[] topKFrequent_Heap(int[] nums, int k)
    {
        Queue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(10, (first,second) -> second.getValue() - first.getValue() );

        for (Map.Entry entry : countOccurrences(nums).entrySet())
        {
            pq.offer(entry);
        }

        int [] topK = new int[k];

        for(int i=0; i < k; i++)
            topK[i] = pq.poll().getKey();

        return topK;
    }

    public int[] topKFrequent_BucketSort(int[] nums, int k)
    {
        List<List<Integer>> buckets = new ArrayList<>();
        for(int i=0; i<=nums.length; i++) buckets.add(null);

        for (Map.Entry<Integer, Integer> entry : countOccurrences(nums).entrySet())
        {
            if ( buckets.get(entry.getValue()) != null)
            {
                List<Integer> list = buckets.get(entry.getValue());
                list.add(entry.getKey());
            }
            else
            {
                buckets.set(entry.getValue(), new ArrayList<>() {{ add(entry.getKey()); }} );
            }
        }

        int topkCount = 0;
        int [] topK = new int[k];

        for (int i=buckets.size()-1; i > 0; i--)
        {
            List<Integer> values  = buckets.get(i);

            if (values != null)
            {
                for (Integer val : values)
                {
                    topK[topkCount++] = val;

                    if (topkCount >= k)
                        return topK;
                }
            }
        }

        return topK;
    }


    @Test
    public void test()
    {
        assert (Arrays.equals( new int[] {1,2} , topKFrequent_Heap(new int[] {1,1,1,2,2,3}, 2)));
        assert (Arrays.equals( new int[] {1,2,3} , topKFrequent_Heap(new int[] {1,1,1,2,2,2,3}, 3)));
        assert (Arrays.equals( new int[] {1,3} , topKFrequent_Heap(new int[] {1,1,1,2,2,3,3}, 2)));
        assert (Arrays.equals( new int[] {1} , topKFrequent_Heap(new int[] {1}, 1)));

        assert (Arrays.equals( new int[] {1,2} , topKFrequent_BucketSort(new int[] {1,1,1,2,2,3}, 2)));
        assert (Arrays.equals( new int[] {1,2,3} , topKFrequent_BucketSort(new int[] {1,1,1,2,2,2,3}, 3)));
        assert (Arrays.equals( new int[] {1,2} , topKFrequent_BucketSort(new int[] {1,1,1,2,2,3,3}, 2)));
        assert (Arrays.equals( new int[] {1} , topKFrequent_BucketSort(new int[] {1}, 1)));
    }
}
