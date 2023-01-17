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
        public boolean helper(TreeNode p,TreeNode q)
    {
        if((p==null&q!=null)||(p!=null&&q==null)) return false;
        if(p==null&&q==null) return true;
        if(p.val!=q.val) return false;
  boolean left=helper(p.left,q.right);
        if(left==false) return false;
        boolean right=helper(p.right,q.left);
        if(right==false) return false;
        return true;
    }
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left,root.right);
    }
}