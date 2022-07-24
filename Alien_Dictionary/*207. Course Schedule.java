Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.
  
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degree = new int[numCourses];
        // build a graph and record indegree
        for (int[] p : prerequisites) {
            if (!graph.containsKey(p[1])) {
                graph.put(p[1], new ArrayList<>());
            } 
            graph.get(p[1]).add(p[0]);
            degree[p[0]]++;
        }
        // put the obj with indegree 0 into the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) q.offer(i);
        }
        int count = 0;
        while (!q.isEmpty()) {
            int course = q.poll();
            count++;
            if (graph.get(course) != null) {
                for (int n : graph.get(course)) {
                    if (--degree[n] == 0) q.offer(n);
                }
            }
        }
        return count == numCourses;
    }
}
