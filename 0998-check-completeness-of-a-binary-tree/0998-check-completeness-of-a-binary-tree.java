/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
            boolean bNull = false;
        while(!queue.isEmpty()) {
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if(node == null) {
                    bNull = true;
                }
                if(node != null) {
                    if(bNull) return false;
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }
        }

        return true;
        
    }
}