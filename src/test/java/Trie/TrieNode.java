package Trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode
{
    boolean endOfWord;
    Map<Character, TrieNode> map = new HashMap<Character, TrieNode>();

    public TrieNode()
    {

    }

    public TrieNode(boolean endOfWord)
    {
        this.endOfWord = endOfWord;
    }

}
