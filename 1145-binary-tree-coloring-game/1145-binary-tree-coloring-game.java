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
    public TreeNode helper1(TreeNode root,int x)
    {
        if(root==null) return null;
        if(root.val==x)
            return root;
        TreeNode left=helper1(root.left,x);
        if(left!=null) return left;
        TreeNode right=helper1(root.right,x);
        if(right!=null) return right;
        return null;
    }
    public int helper2(TreeNode root)
    {
        if(root==null) return 0;
        int left=helper2(root.left);
        int right=helper2(root.right);
        return left+right+1;
    }
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        TreeNode curr=helper1(root,x);
        int  leftSize=helper2(curr.left);
        int rightSize=helper2(curr.right);
        int rem=n-leftSize-rightSize-1;
        int max=Math.max(Math.max(leftSize,rightSize),rem);
        int rem2=n-max-1;
        if(max>rem2+1)
            return true;
        return false;
        
    }
}