package DP;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreak
{
    boolean [] dp;

    public boolean wordBreak(String s, List<String> wordDict)
    {
        dp = new boolean[s.length()];
        Arrays.fill(dp, true);

        return wordBreak(s, 0, wordDict);
    }

    public boolean wordBreak(String s, int idx, List<String> wordDict)
    {
        for(int i=idx; i<s.length(); i++)
        {
            String text = s.substring(idx, i+1);

            for (String word : wordDict)
            {
                if (text.equals(word) && i == s.length()-1)
                    return true;
                else if(text.equals(word) && dp[i] )
                    return wordBreak(s, i+1, wordDict);
            }

        }

        dp[idx] = false;
        return false;
    }

    @Test
    public void test()
    {
        assert (wordBreak("leetcode", Arrays.asList("leet","code")));
        assert (wordBreak("leetcodeneet", Arrays.asList("leet","code", "neet")));
        assert (!wordBreak("leetscode", Arrays.asList("leet","code", "neet")));
    }
}
