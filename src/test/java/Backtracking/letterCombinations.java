package Backtracking;

// Letter Combinations of a Phone Number - leetcode 17

import org.junit.Test;

import java.util.*;

public class letterCombinations
{
    List<String> list = new ArrayList<>();
    Map<Character, String> map = new HashMap<>();
    String digits = "";

    public List<String> letterCombinations(String digits)
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        this.digits = digits;
        generate(0, "");

        return list;
    }

    public void generate(int idx, String word)
    {
        if (idx >= digits.length())
        {
            list.add(word);
            return;
        }

        for (Character c : map.get(digits.charAt(idx)).toCharArray())
        {
            generate(idx+1, word + String.valueOf(c));
        }
    }

    @Test
    public void test()
    {
        System.out.println(letterCombinations("23").toString());
    }
}
