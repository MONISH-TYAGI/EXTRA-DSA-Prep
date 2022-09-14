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
    static class Pair{
        boolean isBalanced=true;
        int height=0;
    }
    public Pair helper(TreeNode root)
    {
        if(root==null) return new Pair();
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        Pair curr=new Pair();
        curr.height=Math.max(left.height,right.height)+1;
        boolean currVal=(Math.abs(left.height-right.height)>1)?false:true;
        curr.isBalanced=(currVal&&left.isBalanced&&right.isBalanced);
        return curr;
    }
    public boolean isBalanced(TreeNode root) {
        
        return helper(root).isBalanced;
    }
}