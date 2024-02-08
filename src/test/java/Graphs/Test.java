package Graphs;

import Heap.KthLargestElementInAStream;

import java.util.PriorityQueue;
import java.util.Queue;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*
 * Complete the 'calculate' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY distances
 *  2. INTEGER_ARRAY prices
 */

public class Test
{


    @org.junit.Test
    public void test()
    {
        // distances : [10, 40, 10, 30, 30, 20] prices : [4, 3, 2, 1, 2, 1]
        // distances : [30, 30, 30, 30, 30, 30, 30, 30, 30, 30] prices : [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
        // distances : [20, 19, 18, 17, 16, 15] prices : [2, 3, 4, 5, 2, 3]
        // distances : [10]prices : [1] = 10
        // distances : [10, 10, 10]prices : [2, 3, 3] = 60
        // distances : [10, 10, 10]prices : [2, 3, 1] = 50
        // distances : [10, 10, 10, 30] prices : [2, 3, 4, 5] = 130


        assert ( 270 == calculate( Arrays.asList(new Integer[]{10, 40, 10, 30, 30, 20}), Arrays.asList(new Integer[] {4, 3, 2, 1, 2, 1}) ));
        //assert ( 130 == calculate( Arrays.asList(new Integer[]{10, 10, 10, 30}), Arrays.asList(new Integer[] {2, 3, 4, 5}) ));
        //assert ( 140 == calculate( Arrays.asList(new Integer[]{10,20,5,20}), Arrays.asList(new Integer[] {3,4,2,3}) ));
    }

    public static int calculate(List<Integer> distances, List<Integer> prices)
    {
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((e1,e2) -> e1.getKey() - e2.getKey());

        int currentPrice = prices.get(0);
        int currentDistance = 0;
        int minCost = 0;

        for(int i=1; i<=prices.size(); i++)
        {
            currentDistance += distances.get(i-1);

            if(currentDistance <= 50 && i < prices.size())
            {
                if(currentPrice > prices.get(i))
                {
                    minCost += currentDistance * currentPrice;
                    currentPrice = prices.get(i);
                    currentDistance = 0;

                    q = new PriorityQueue<>((e1,e2) -> e1.getKey() - e2.getKey());
                }
                else
                {
                    q.offer(new AbstractMap.SimpleEntry<>(prices.get(i), currentDistance));
                }
            }
            else if(currentDistance > 50)
            {
                minCost += currentPrice * 50;

                Map.Entry<Integer, Integer> entry = q.peek();

                int lastFilledDistance = 0;

                while( !q.isEmpty() && (currentDistance - lastFilledDistance - 50) >= entry.getValue() - lastFilledDistance)
                {
                    //entry = q.poll();

                    if(entry.getValue() > lastFilledDistance)
                    {
                        minCost += entry.getKey() *  (entry.getValue() - lastFilledDistance);
                        lastFilledDistance = entry.getValue();
                    }

                   entry = q.poll();
                }

                if(entry != null)
                {
                    currentDistance = currentDistance - entry.getValue();
                    currentPrice = entry.getKey();
                }
            }
            else
            {
                minCost += currentDistance * currentPrice;
            }
        }

        //minCost += (currentDistance + distances.get(distances.size()-1)) * currentPrice;

        return minCost;
    }
}


//    public class Solution {
//        public static void main(String[] args) throws IOException {
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//            int distancesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> distances = IntStream.range(0, distancesCount).mapToObj(i -> {
//                try {
//                    return bufferedReader.readLine().replaceAll("\\s+$", "");
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            })
//                    .map(String::trim)
//                    .map(Integer::parseInt)
//                    .collect(toList());
//
//            int pricesCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//            List<Integer> prices = IntStream.range(0, pricesCount).mapToObj(i -> {
//                try {
//                    return bufferedReader.readLine().replaceAll("\\s+$", "");
//                } catch (IOException ex) {
//                    throw new RuntimeException(ex);
//                }
//            })
//                    .map(String::trim)
//                    .map(Integer::parseInt)
//                    .collect(toList());
//
//            int result = Result.calculate(distances, prices);
//
//            bufferedWriter.write(String.valueOf(result));
//            bufferedWriter.newLine();
//
//            bufferedReader.close();
//            bufferedWriter.close();
//        }
//    }

//    @org.junit.Test
//    public void test()
//    {
//        //calculatet(3, new int[]{4, 5, 8, 2});
//
//        Queue<Integer> pq = new PriorityQueue<>(5, (a, b) -> b - a);
//        pq.offer(3);
//        pq.offer(4);
//        pq.offer(1);
//        pq.offer(2);
//
//        System.out.println(pq.peek());
//    }

