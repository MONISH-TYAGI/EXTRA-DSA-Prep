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
int diameter=0;
        int height=0;

    }
    public Pair helper(TreeNode root)
    {
        if(root==null) return new Pair();
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        Pair curr=new Pair();
        curr.height=Math.max(left.height,right.height)+1;
       int dia=0;
if(root.left!=null&&root.right!=null)
    dia=left.height+right.height;
else if(root.left!=null)
    dia=left.height;
else if(root.right!=null)
    dia=right.height;
    curr.diameter=Math.max(dia,Math.max(left.diameter,right.diameter));
      
        return curr;
    }
    public int diameterOfBinaryTree(TreeNode root) {
                return helper(root).diameter;
    }
}