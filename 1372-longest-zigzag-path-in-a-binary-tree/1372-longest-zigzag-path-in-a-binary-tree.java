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
    class Pair{
        int left;
        int right;
        int max;
        Pair()
        {
            left=0;
            right=0;
            max=0;
        }
            
    }
    public Pair helper(TreeNode root)
    { 
        if(root.left==null&&root.right==null)
            return new Pair();
        // if(root.left==null||root.right==null)
        //     return new Pair(0,0,0);
        Pair ans=new Pair();
        if(root.left!=null){
        Pair left=helper(root.left);
        ans.left=left.right+1;
            ans.max=Math.max(ans.max,left.max);
        }
        if(root.right!=null){
        Pair right=helper(root.right);
        ans.right=right.left+1;
            ans.max=Math.max(ans.max,right.max);
        }
        ans.max=Math.max(ans.max,Math.max(ans.right,ans.left));
// System.out.println(ans.left+" "+ans.right+" "+ans.max);
        return ans;
    }
    public int longestZigZag(TreeNode root) {
        return helper(root).max;
    }
}