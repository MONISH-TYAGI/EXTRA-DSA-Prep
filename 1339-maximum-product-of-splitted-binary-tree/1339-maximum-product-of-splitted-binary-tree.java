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
    long max;
    public int replace(TreeNode root){
        if(root==null)return 0;
        
        root.val=replace(root.left)+replace(root.right)+root.val;
        return root.val;
    }
    
    public void helper(TreeNode root, long total){
        
        if(root.left!=null){
            helper(root.left,total);
            max=Math.max(root.left.val * (total-root.left.val),max);
            
            
        }
        if(root.right!=null){
            helper(root.right,total);
            max=Math.max(root.right.val * (total-root.right.val),max);
            
        }
        return;
        
        
    }
    
    public int maxProduct(TreeNode root) {
        
        max=0;
        long t=replace(root);
        helper(root,t);
        return (int)(max%1000000007l);
        
    }
}