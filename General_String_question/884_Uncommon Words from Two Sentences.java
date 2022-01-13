A sentence is a string of single-space separated words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.
  
Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == 1) {
                list.add(key);
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
