package Test;

import Intervals.MeetingRooms;

import java.util.*;

public class Test
{
    boolean test(int[] arr)
    {


        return false;
    }

    @org.junit.Test
    public void test()
    {
        assert (test(new int[]{1, 2, 3}));
        //assert (canAttendMeetings(new MeetingRooms.Interval[]{new MeetingRooms.Interval(7,10), new MeetingRooms.Interval(2,4)}));
    }




    public int foo(List<List<Integer>> samples)
    {
        int i,j;
        int r = samples.size();
        int c = samples.get(0).size();
        int S[][] = new int[r][c];
        int M[][]=new int[r][c];
        for(int d=0;d<r;d++) {
            for(int b=0;b<c;b++) {
                M[d][b]=samples.get(d).get(b);
            }
        }
        int max_of_s, max_i, max_j;
        for(i = 0; i < r; i++)
            S[i][0] = M[i][0];
        for(j = 0; j < c; j++)
            S[0][j] = M[0][j];
        for(i = 1; i < r; i++) {
            for(j = 1; j < c; j++) {
                if(M[i][j] == 1) {
                    S[i][j] = Math.min(S[i][j-1],
                            Math.min(S[i-1][j], S[i-1][j-1])) + 1;
                }
                else
                    S[i][j] = 0;
            }

        }
        max_of_s = S[0][0]; max_i = 0; max_j = 0;
        for(i = 0; i < r; i++) {
            for(j = 0; j < c; j++) {
                if(max_of_s < S[i][j]) {
                    max_of_s = S[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        return Math.abs((max_i-max_of_s)-max_i);
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k)
    {
        Set<String> positiveWords = new HashSet<>();
        Set<String> negativeWords = new HashSet<>();

        for (String word: positiveKeywords.split(" ")) {
            positiveWords.add(word.toLowerCase());
        }

        for (String word: negativeKeywords.split(" ")) {
            negativeWords.add(word.toLowerCase());
        }

        Map<Integer, Integer> hotelScore = new HashMap<>();
        for (int i = 0; i < reviews.size(); i++) {
            int hotel = hotelIds.get(i);
            int score = hotelScore.getOrDefault(hotel, 0);
            List<String> review = Arrays.asList(reviews.get(i).split(" "));

            int pos=0, neg=0;
            for (String word: reviews.get(i).split(" ")) {
                if (word.charAt(word.length()-1) == '.' || word.charAt(word.length()-1) == ',') {
                    word = word.substring(0, word.length() - 1);
                }
                if (positiveWords.contains(word.toLowerCase())) {
                    pos++;
                }
                if (negativeWords.contains(word.toLowerCase())) {
                    neg++;
                }
            }
            hotelScore.put(hotel, score + 3*pos - neg);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<Integer, Integer> entry: hotelScore.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        List<Integer> result = new ArrayList<>();
        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }

}
