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
    public int height(TreeNode root)
    {
        int ans=0;
        TreeNode left=root;
        while(left!=null)
        {
            left=left.left;
            ans++;
        }
        return ans;
    }
        public int height2(TreeNode root)
    {
        int ans=0;
        TreeNode right=root;
        while(right!=null)
        {
            right=right.right;
            ans++;
        }
        return ans;
    }
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left=height(root);
        int right=height2(root);
        if(left==right) return (1<<left)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
}