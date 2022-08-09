package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode
{
    Character c;
    boolean endOfWord;
    Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();

    public TrieNode()
    {

    }

    public TrieNode(Character c, boolean endOfWord)
    {
        this.c = c;
        this.endOfWord = endOfWord;
    }

}
