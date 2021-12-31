Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
You can return the answer in any order.
  
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        Map<TreeNode, TreeNode> map = new HashMap<>();// build a map to store child-parent collection
        dfs(map, root, root);
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();// check if the node has been visited
        q.offer(target);
        visited.add(target);
        int lev = 0;
        while (q.size() > 0) {
            int size = q.size();
            // if it is k level, which all the node inside the queue are the answer
            if (lev == k) {
                while (q.size() > 0) {
                    res.add(q.poll().val);
                }
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                //check its left child
                if (cur.left != null && !visited.contains(cur.left)) {
                    q.offer(cur.left);
                    visited.add(cur.left);
                }
                // check its right child
                if (cur.right != null && !visited.contains(cur.right)) {
                    q.offer(cur.right);
                    visited.add(cur.right);
                }
                // check its parent node, these the i-distance node with target
                TreeNode parent = map.get(cur);
                if (!visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                }
            }
            lev++;
        }
        return res;
    }
    // get all the children-parent map
    public void dfs(Map<TreeNode, TreeNode> map, TreeNode node, TreeNode par) {
        if (node != null) {
            map.put(node, par);
            dfs(map, node.left, node);
            dfs(map, node.right, node);
        }
    }
}
