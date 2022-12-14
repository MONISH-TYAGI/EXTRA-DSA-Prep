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
    public TreeNode helper(TreeNode root1,TreeNode root2)
    {
        if(root1==null&&root2==null) return null;
          TreeNode root=new TreeNode();
       
        TreeNode leftNode1=(root1==null||root1.left==null)?null:root1.left;
          TreeNode rightNode1=(root1==null||root1.right==null)?null:root1.right;
        TreeNode leftNode2=(root2==null||root2.left==null)?null:root2.left;
          TreeNode rightNode2=(root2==null||root2.right==null)?null:root2.right;
root.left=helper(leftNode1,leftNode2);
      root.right=  helper(rightNode1,rightNode2);
         int left=(root1==null)?0:root1.val;
        int right=(root2==null)?0:root2.val;
        root.val=left+right;
        return root;
        
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        return helper(root1,root2);
        
    }
}