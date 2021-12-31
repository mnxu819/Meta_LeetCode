A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
  
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 有一个test case里面wordlist很长，会超时。所以要转成set，因为list的contains操作是O(n)，set的contains操作是O(1),其实是单词的长度;
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {    //将wordList中的单词加入dict
            dict.add(word);
        }
        int res = 1;
        Queue<String> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        q.offer(beginWord);
        set.add(beginWord);
        while (!q.isEmpty()){
            res++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                List<String> oneDistanceWords = getOneDistanceWord(cur, dict);
                for (String oneDistanceWord : oneDistanceWords) {
                    if (set.contains(oneDistanceWord)) {
                        continue;
                    }
                    if (oneDistanceWord.equals(endWord)) {
                        return res;
                    }
                    q.offer(oneDistanceWord);
                    set.add(oneDistanceWord);
                }
            }     
        }
        return 0;
    }
    public List<String> getOneDistanceWord(String word, Set<String> dict) {
        List<String> res = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) continue;
                if (dict.contains(replace(word, i, c))) {
                    res.add(replace(word, i, c));
                }
            }
        }
        return res;
    }
    public String replace(String s, int index, char c) {
        char[] charArr = s.toCharArray();
        charArr[index] = c;
        return new String(charArr);
    }
}
