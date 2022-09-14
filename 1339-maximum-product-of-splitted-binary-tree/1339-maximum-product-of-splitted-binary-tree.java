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
    long max=0;
    public long helper1(TreeNode root)
    {
        if(root==null) return 0l;
        long leftSum=helper1(root.left);
        long rightSum=helper1(root.right);
        return leftSum+rightSum+root.val*1l;
    }
    public long helper2(TreeNode root,long totalSum)
    {
        if(root==null) return 0l;
        long leftSum=helper2(root.left,totalSum);
        long rightSum=helper2(root.right,totalSum);
        long currVal=leftSum+rightSum+root.val*1l;
        long prod=currVal*(totalSum-currVal);
        max=Math.max(max,prod);
        return currVal;
    }
    public int maxProduct(TreeNode root) {
   long totalSum=helper1(root); 
   helper2(root,totalSum);
        return (int)(max%1000000007);
    }
}