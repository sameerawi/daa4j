package Trie;

// Given a list of usernames, figure out the shortest substring that's still long enough to uniquely identify the name within the set
// 'skemper'  -> ske
// 'schacko'  -> sc
// 'eweitz'   -> e
// 'kfisher'  -> kfi
// 'kfellman' -> kfe
// 'kgeller'  -> kg
// 'abskld'   -> a
// 'skatlk'   -> ska

import org.junit.Test;

import java.util.*;

public class ShortestUniqueSubString
{
    public class TrieEx extends Trie
    {
        public String extractPrefix(String word)
        {
            Queue<Character> q = new LinkedList();
            for (char c : word.toCharArray())
                q.offer(c);

            return _extractPrefix(this.root, q);
        }

        String _extractPrefix(TrieNode node, Queue<Character> q)
        {
            if (q.size() < 1)
                return "";
            else
            {
                Character c = q.poll();

                TrieNode curr = node.map.get(c);

                String postFix = _extractPrefix(curr, q);

                if (postFix.equals("") && !node.endOfWord && node.map.size() < 2 )
                    return "";
                else
                    return c.toString() + postFix;
            }
        }

        public List<String> extractPrefixes()
        {
            return _extractPrefixes(this.root);
        }

        List<String> _extractPrefixes(TrieNode node)
        {
            List<String> list = new ArrayList<>();

            if (node.endOfWord)
                list.add("");

            for (Map.Entry<Character, TrieNode> entry : node.map.entrySet())
            {
                List<String> tempList = _extractPrefixes(entry.getValue());

                if (tempList.size() == 1)
                {
                    list.add(entry.getKey().toString());
                    continue;
                }

                for( String postFix : tempList)
                {
                    list.add(entry.getKey() + postFix);
                }
            }

            return list;
        }
    }

    public Map<String,String> shortestUniqueSubString(List<String> words)
    {
        TrieEx trie = new TrieEx();

        for (String word : words)
        {
            trie.insert(word);
        }

        Map<String,String> ret = new HashMap<>();

        for (String word : words)
        {
            ret.put(word, trie.extractPrefix(word));
        }

        return ret;
    }

    @Test
    public void test()
    {
        List<String> wordList1 = Arrays.asList("skemper", "skatlk", "schacko", "s", "b", "bb", "bcd" , "bcde", "bcdefgi");

        Arrays.asList("b", "bb", "bcd", "", "", "", "", "", "", "", "", "", "", "", "");

        Map<String,String> map = shortestUniqueSubString(wordList1);
        assert (map.get("skemper").equals("ske"));
        assert (map.get("bcdefgi").equals("bcdef"));
        assert (map.get("b").equals("b"));
        assert (map.get("bb").equals("bb"));
    }
}
