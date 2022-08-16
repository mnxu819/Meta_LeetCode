There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses.
  
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int index = 0;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = getIndegree(numCourses, prerequisites);
        Map<Integer, Set<Integer>> graph = buildGraph(numCourses, prerequisites);
        for (int i = 0; i < numCourses; i++){
            //把入度为0的点都放入队列里
            if (map.get(i) == 0) {
                q.offer(i);
                res[index++] = i;
            }
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            //如果cur是先修课则找到对应的后选课其入度减一
            for (int v : graph.get(cur)) {
                map.put(v, map.get(v)-1);
                if (map.get(v) == 0) {
                    q.offer(v);
                    res[index++] = v;
                }
            }
        }
        return index == numCourses ? res : new int[0];
    }
    public Map<Integer, Set<Integer>> buildGraph(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        return map;
    }
    //建立入度map, key是课程，value是入度，即指向该节点的边数
    public Map<Integer, Integer> getIndegree(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> map = new HashMap<>();
        //先把所有点放进去
        for (int i = 0; i < numCourses; i++) {
            map.put(i, 0);
        }
        //计算入度
        for (int i = 0; i < prerequisites.length; i++) {
            if (map.containsKey(prerequisites[i][0])) {
                map.put(prerequisites[i][0], map.get(prerequisites[i][0])+1);
            }
        }
        return map;
    }
}
