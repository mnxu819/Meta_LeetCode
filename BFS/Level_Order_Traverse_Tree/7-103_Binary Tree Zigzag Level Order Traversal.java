Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
  
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        Boolean isEvenLevel = false;
        while (!q.isEmpty()){
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                tmp.add(cur.val);
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            if (isEvenLevel) {
                Collections.reverse(tmp);
            }
             res.add(tmp);
           isEvenLevel = !isEvenLevel;
        }
        return res;
    }
}  
