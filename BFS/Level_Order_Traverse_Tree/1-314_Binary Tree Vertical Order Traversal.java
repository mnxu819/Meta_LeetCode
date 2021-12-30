/*
Given the root of a binary tree, return the vertical order traversal of its nodes' values. (i.e., from top to bottom, column by column).
If two nodes are in the same row and column, the order should be from left to right.
*/
//Time Complexity O(N), O(N)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> col = new LinkedList<>();
        q.offer(root);
        col.offer(0);
        int min = 0;
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                int curCol = col.poll();
                if (!map.containsKey(curCol)){
                    map.put(curCol, new ArrayList<>());
                }
                map.get(curCol).add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                    col.offer(curCol-1);
                    min = Math.min(min, curCol-1);
                }
                 if (cur.right != null) {
                    q.offer(cur.right);
                    col.offer(curCol+1);
                    max = Math.max(max, curCol+1); 
                }
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;
    }
}
