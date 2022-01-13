We can represent a sentence as an array of words, for example, the sentence "I am happy with leetcode" can be represented as arr = ["I","am",happy","with","leetcode"].
Given two sentences sentence1 and sentence2 each represented as a string array and given an array of string pairs similarPairs where similarPairs[i] = [xi, yi] indicates that the two words xi and yi are similar.
Return true if sentence1 and sentence2 are similar, or false if they are not similar.
                                                                                                                                    
Example 1:
Input: sentence1 = ["great","acting","skills"], sentence2 = ["fine","drama","talent"], similarPairs = [["great","fine"],["drama","acting"],["skills","talent"]]
Output: true
Explanation: The two sentences have the same length and each word i of sentence1 is also similar to the corresponding word in sentence2.
                                                                                                                                    
class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) return false;
        Map<String, Set<String>> map = new HashMap<>();
        for (List<String> similarPair :similarPairs){
            map.putIfAbsent(similarPair.get(0), new HashSet<>());
            map.putIfAbsent(similarPair.get(1), new HashSet<>());
            map.get(similarPair.get(0)).add(similarPair.get(1));
            map.get(similarPair.get(1)).add(similarPair.get(0));
        }
        for (int i = 0; i < sentence1.length; i++) {
            if (sentence1[i].equals(sentence2[i])) continue;
            if (!map.containsKey(sentence1[i])) return false;
            if (!map.get(sentence1[i]).contains(sentence2[i])) return false;
        }
        return true;
    }
}                                                                                                                                    
