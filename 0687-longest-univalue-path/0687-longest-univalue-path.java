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
    int maxLen=0;
    class Pair{
        int val;
        int hei=0;
    }
    public Pair helper(TreeNode root)
    {
       
        if(root.left==null&&root.right==null)
        {
      Pair obj=new Pair();
    obj.val=root.val;
            return obj;
        }
        Pair left=null,right=null;
        if(root.left!=null)
  left=helper(root.left);
        if(root.right!=null)
         right=helper(root.right);
        Pair curr=new Pair();
        curr.val=root.val;
if((left!=null&&right!=null)&&(root.val==left.val&&root.val==right.val))
{
    curr.hei=Math.max(left.hei,right.hei)+1;
    maxLen=Math.max(maxLen,left.hei+right.hei+2);
    return curr;
    
}else if(left!=null&&root.val==left.val)
{
    curr.hei=left.hei+1;
     maxLen=Math.max(maxLen,curr.hei);
    return curr;
}else if(right!=null&&root.val==right.val)
{
 curr.hei=right.hei+1;
     maxLen=Math.max(maxLen,curr.hei);
    return curr;   
}

return curr;
        
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return 0;
        helper(root);
        return maxLen;
    }
}