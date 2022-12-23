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
               long max1=Long.MAX_VALUE;
       long max2=Long.MAX_VALUE;
}
    public  void helper(TreeNode root,Pair pq)
    {
        if(root==null) return ;
        if(root.val<pq.max1)
        {
            pq.max2=1l*pq.max1;
            pq.max1=1l*root.val;
            
        }else if(root.val>pq.max1&&root.val<pq.max2)
        {
pq.max2=1l*root.val;
            // System.out.println(pq.max2);
        }
        helper(root.left,pq);
        helper(root.right,pq);
    }
    public int findSecondMinimumValue(TreeNode root) {
Pair pq=new Pair();
        helper(root,pq);
        if(pq.max2==Long.MAX_VALUE) return -1;
        int ans=(int)pq.max2;
        return ans;
    }
}