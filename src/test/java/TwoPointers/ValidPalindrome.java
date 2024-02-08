package TwoPointers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

// leetcode 125 - Valid Palindrome
//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
// it reads the same forward and backward. Alphanumeric characters include letters and numbers.

public class ValidPalindrome
{

    public boolean isPalindrome(String s)
    {
        char[] str = s.toCharArray(); //s.toLowerCase(Locale.ROOT).replace(" ", "").toCharArray();

        int left = 0, right = str.length-1;

        // racecar
        while (left < right)
        {
            if (!Character.isLetterOrDigit(str[left]))
                left++;
            else if (!Character.isLetterOrDigit(str[right]))
                right--;
            else
            {
                if (Character.toLowerCase(str[left]) != Character.toLowerCase(str[right]) )
                    return false;

                left++;
                right--;
            }
        }

        return true;
    }

    @Test
    public void test()
    {
//       assert (groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"})
//                .equals(Arrays.asList(Arrays.asList(new String [] {"tan","nat"}, new String [] {"eat", "tea", "ate"}, new String [] {"bat"}))));

        assert (isPalindrome("A man, a plan, a canal: Panama"));
        assert (!isPalindrome("race a car"));
        assert (isPalindrome(" "));
    }
}
