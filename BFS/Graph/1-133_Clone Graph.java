Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}


/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        List<Node> nodes = getAllNodes(node);
        Map<Node, Node> map = new HashMap<>();
        // copy the node
        for (Node n : nodes) {
            map.put(n, new Node(n.val));
        }
        //copy the edge
        for (Node n : nodes) {
            for (Node neighbor : n.neighbors) {
                map.get(n).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    public List<Node> getAllNodes(Node node) {
        Set<Node> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (!set.contains(cur)) {
                set.add(cur);
                for (Node neighbor : cur.neighbors) {
                    q.offer(neighbor);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
