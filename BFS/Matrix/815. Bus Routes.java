You are given an array routes representing bus routes where routes[i] is a bus route that the ith bus repeats forever.
Input: routes = [[1,2,7],[3,6,7]], source = 1, target = 6
Output: 2
Explanation: The best strategy is take the first bus to the bus stop 7, then take the second bus to the bus stop 6.
  
class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //O(V+E)
        if (source == target) return 0;
        int count = 0;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Set<Integer> isV = new HashSet<>();//check if the bus has been taken
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        //build graph, 比如127,367,stop7对应的value是bus1和2，因为两辆车都有7
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                ArrayList<Integer> bus = map.getOrDefault(routes[i][j], new ArrayList<>());
                bus.add(i);
                map.put(routes[i][j], bus);
            }
        }
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                for (int busNum : map.get(cur)) {
                    //check if current bus is already taken
                    if (isV.contains(busNum)) continue;
                    isV.add(busNum);
                    for (int j = 0; j < routes[busNum].length; j++) {
                        if (routes[busNum][j] == target) return count;
                        q.offer(routes[busNum][j]);
                    }
                }
            }
        }
        return -1;
    }
}
