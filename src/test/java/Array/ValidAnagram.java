package Array;

import org.junit.Test;

// leetcode 242 - Valid Anagram
// Given two strings s and t, return true if t is an anagram of s, and false otherwise.

public class ValidAnagram
{
    public boolean isAnagram(String s, String t)
    {
        int [] alphabet = new int[26];

        for(char c : s.toCharArray())
        {
            alphabet[c-97]++;
        }

        for(char c : t.toCharArray())
        {
            alphabet[c-97]--;
        }

        for (int i : alphabet)
        {
            if (i != 0)
                return false;
        }

        return true;
    }

    @Test
    public void test()
    {
        assert (isAnagram("anagram", "nagaram"));
        assert (!isAnagram("rat", "car"));
    }
}
