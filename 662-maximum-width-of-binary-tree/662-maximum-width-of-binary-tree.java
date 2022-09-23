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
        long min;
        long max;
        Pair(long x,long y)
        {
            min=x;
            max=y;
        }
    }
    long maxW=1l;
    public void helper(int depth,long idx,HashMap<Integer,Pair> hm,TreeNode root)
    {
        if(root==null) return ;
        if(hm.containsKey(depth))
        {
            Pair curr=hm.get(depth);
            curr.min=Math.min(curr.min,idx);
                curr.max=Math.max(curr.max,idx);
            maxW=Math.max(maxW,(curr.max-curr.min)+1l);
            hm.put(depth,curr);
        }else
        {
         Pair curr=new Pair(idx,idx);
            hm.put(depth,curr);
        }
        helper(depth+1,2*idx,hm,root.left);
        helper(depth+1,2*idx+1,hm,root.right);
        
        
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        HashMap<Integer,Pair> hm=new HashMap<>();
        helper(0,1l,hm,root);
            return (int)maxW;
    }
}