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
    int i=0;
    public TreeNode recoverFromPreorder(String traversal) {
        return helper(traversal,0);
    }
    public TreeNode helper(String traversal,int depth)
    {
        int j=0;
        while(i+j<traversal.length()&&traversal.charAt(i+j)=='-')
            j++;
        if(j!=depth) return null;
        int k=0;
        while(i+j+k<traversal.length()&&traversal.charAt(i+j+k)!='-')
            k++;
        int val=Integer.parseInt(traversal.substring(i+j,i+j+k));
        i=i+j+k;
        TreeNode node=new TreeNode(val);
        node.left=helper(traversal,depth+1);
        node.right=helper(traversal,depth+1);
        return node;
    }
    
}