package Trie;

// Implement Trie (Prefix Tree) - Leetcode 208

import org.junit.Test;

public class Trie
{
    TrieNode root = new TrieNode();

    public void insert(String word)
    {
        TrieNode curNode = root;

        for (Character c : word.toCharArray())
        {
            TrieNode temp = curNode.map.get(c);

            if( temp == null)
            {
                temp = new TrieNode(c, false);
                curNode.map.put(c, temp);
            }

            curNode = temp;
        }

        curNode.endOfWord = true;
    }

    public boolean startsWith(String prefix)
    {
        TrieNode curNode = root;

        for (Character c : prefix.toCharArray())
        {
            TrieNode temp = curNode.map.get(c);

            if(temp != null)
                curNode = temp;
            else
                return false;
        }

        return true;
    }

    public boolean search(String word)
    {
        TrieNode curNode = root;

        for (Character c : word.toCharArray())
        {
            TrieNode temp = curNode.map.get(c);

            if(temp != null)
                curNode = temp;
            else
                return false;
        }

        return curNode.endOfWord;
    }

    @Test
    public void testTrie()
    {
        Trie prefixTree = new Trie();

        prefixTree.insert("apple");
        prefixTree.insert("app");
        prefixTree.insert("orange");
        prefixTree.insert("organize");
        prefixTree.insert("zoo");
        prefixTree.insert("zebra");
        prefixTree.insert("John");
        prefixTree.insert("jump");

        assert(prefixTree.search("apple"));
        assert(prefixTree.search("app"));
        assert(prefixTree.search("orange"));
        assert(prefixTree.search("organize"));
        assert(prefixTree.search("zoo"));
        assert(prefixTree.search("zebra"));
        assert(prefixTree.search("John"));
        assert(prefixTree.search("jump"));

        assert(prefixTree.startsWith("a"));
        assert(prefixTree.startsWith("app"));
        assert(prefixTree.startsWith("apple"));
        assert(prefixTree.startsWith("org"));
        assert(prefixTree.startsWith("zoo"));
        assert(prefixTree.startsWith("zebra"));
        assert(prefixTree.startsWith("John"));
        assert(prefixTree.startsWith("J"));
        assert(prefixTree.startsWith("j"));
        assert(!prefixTree.startsWith("f"));
    }
}
