package Stack;

// leetcode 20 - Valid Parentheses
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses
{
    public boolean isValid(String s)
    {
        Map<Character, Character> charMap = Map.of('}','{', ')','(',']','[');

        Stack<Character> stack = new Stack();
        //stack.push(s.charAt(0));

        for (int i=0; i<s.length(); i++)
        {
            if ( !charMap.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            else if ((stack.isEmpty()) || charMap.get(s.charAt(i)) != stack.pop())
                return false;
        }

        return stack.isEmpty();
    }

    @Test
    public void test()
    {
        assert (isValid("()"));
        assert (isValid("()[]{}"));
        assert (!isValid("(]"));
        assert (isValid("(((())))"));
        assert (isValid("[({})]"));
        assert (!isValid("[({[}])]"));
        assert (!isValid("["));
        assert (!isValid("]"));
        assert (!isValid("[]("));
    }
}
