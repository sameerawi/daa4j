package Array;

// leetcode 49 - Group Anagrams
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

import org.junit.Test;

import java.util.*;

public class GroupAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs)
        {
            char [] chars = new char[26];

            for(char c : str.toCharArray()) chars[c - 'a']++;

            if (!map.containsKey(String.valueOf(chars))) map.put(String.valueOf(chars), new ArrayList<>());

            map.get(String.valueOf(chars)).add(str);
        }

        return new ArrayList<>(map.values());
    }

    @Test
    public void test()
    {
//       assert (groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"})
//                .equals(Arrays.asList(Arrays.asList(new String [] {"tan","nat"}, new String [] {"eat", "tea", "ate"}, new String [] {"bat"}))));

       assert (groupAnagrams(new String[] {"a"})
                .equals(Arrays.asList(Arrays.asList( new String [] {"a"}))));

    }
}
