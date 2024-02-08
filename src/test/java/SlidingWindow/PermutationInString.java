package SlidingWindow;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// leetcode 567 - Permutation in String
// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.

public class PermutationInString
{
    public boolean checkInclusion_map(String s1, String s2)
    {
        Map<Character, Integer> s1map = new HashMap<>();
        Map<Character, Integer> s2map = new HashMap<>();

        fillMap(s1, s1map);
        //fillMap(s2, s2map);

        int windowSize = s1.length();

        Character lastChar = '0';
        for (int i=0; i<s2.length()-windowSize; i++)
        {
            if (s2map.isEmpty())
            {
                for (char c = 'a'; c <= 'z'; c++)
                    s2map.put(c, 0);
                for (int j = i; j < i+windowSize; j++)
                    s2map.put(s2.charAt(j), s2map.getOrDefault(s2.charAt(j), 0) + 1);
            }
            else
            {
                s2map.put(s2.charAt(i-1), s2map.getOrDefault(s2.charAt(i-1), 0) - 1);
                s2map.put(s2.charAt(i+windowSize-1), s2map.getOrDefault(s2.charAt(i+windowSize-1), 0) + 1);
            }

            boolean allMatch = false;
            for (Map.Entry entry : s1map.entrySet())
            {
                if (s2map.get(entry.getKey()) != entry.getValue())
                {
                    allMatch = false;
                    break;
                }

                allMatch = true;
            }

            if (allMatch)
                return true;
        }

        return false;
    }

    public boolean checkInclusion_array(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    public void fillMap(String s,  Map<Character, Integer> map)
    {
        for (char c = 'a'; c <= 'z'; c++)
            map.put(c, 0);

        for(Character c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);
    }

    @Test
    public void test()
    {
        assert (checkInclusion_map("ab", "eidbaooo"));
        assert (!checkInclusion_map("ab", "eidboaoo"));
        assert (checkInclusion_array("ab", "eidbaooo"));
        assert (!checkInclusion_array("ab", "eidboaoo"));
    }
}
