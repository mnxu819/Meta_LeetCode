There is a new alien language that uses the English alphabet. However, the order among the letters is unknown to you.
You are given a list of strings words from the alien language's dictionary, where the strings in words are sorted lexicographically by the rules of this new language.
Return a string of the unique letters in the new alien language sorted in lexicographically increasing order by the new language's rules. If there is no solution, return "". If there are multiple solutions, return any of them.
A string s is lexicographically smaller than a string t if at the first letter where they differ, the letter in s comes before the letter in t in the alien language. If the first min(s.length, t.length) letters are the same, then s is smaller if and only if s.length < t.length.
  
Example 1:
Input: words = ["wrt","wrf","er","ett","rftt"]
Output: "wertf"
  
class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> graph = constructGraph(words);
        if (graph == null) return "";
        return tpSorting(graph);
    }
    public Map<Character, Set<Character>> constructGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        
        //create node, find all the characters displayed in the dic
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char c = words[i].charAt(j);
                if (!graph.containsKey(c)) {
                    graph.put(c, new HashSet<Character>());
                }
            }
        }
        // create edges
        for (int i = 0; i < words.length-1; i++) {
            int index = 0;
            while (index < words[i].length() && index < words[i+1].length()) {
                //eg: abcad abddd, c and d, c->d, the following letters dont need to be considered
                if (words[i].charAt(index) != words[i+1].charAt(index)) {
                    graph.get(words[i].charAt(index)).add(words[i+1].charAt(index));
                    break;
                }
                index++;
            }
            //?????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????null
            if (index == Math.min(words[i].length(), words[i+1].length())) {
                 if (words[i].length() > words[i + 1].length()) {
                    return null;
                }
            }
        }
        return graph;
    }
    public Map<Character, Integer> getIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for (Character u : graph.keySet()) {
            indegree.put(u, 0);//?????????????????????
        }
        for (Character u : graph.keySet()) {
            for (Character v : graph.get(u)) {
                indegree.put(v,  indegree.get(v)+1);//???????????????key??????value,???????????????????????????????????????????????????????????????
            }
        }
        return indegree;
    }
    public String tpSorting(Map<Character, Set<Character>> graph){
        Map<Character, Integer> indegree = getIndegree(graph);
        Queue<Character> q = new PriorityQueue<>();//?????????0????????????????????????stringbuilder?????????????????????????????????linkedlist?????????
        
        for (Character u : indegree.keySet()) {
            if (indegree.get(u) == 0) {
                q.offer(u);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            Character head = q.poll();
            sb.append(head);
            for (Character neighbor : graph.get(head)) {
                indegree.put(neighbor, indegree.get(neighbor)-1);
                if (indegree.get(neighbor) == 0) {
                    q.offer(neighbor);
                }
            }
        }
        return sb.length() == indegree.size() ? sb.toString() : "";
        
    }
}
