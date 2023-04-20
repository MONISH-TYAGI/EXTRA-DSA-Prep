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
    int max=1;
    class Pair{
       
        int min;
        int max;
        Pair(int y,int z)
        {
            
            min=y;
            max=z;
        }
    }
    public void helper(TreeNode root,int count,HashMap<Integer,Pair> hm,int depth)
    {
        if(root==null) return ;
       
    if(hm.containsKey(depth)==true)
    {
        Pair curr=hm.get(depth);
        curr.min=Math.min(curr.min,count);
        curr.max=Math.max(curr.max,count);
        max=Math.max(max,Math.abs(curr.max-curr.min)+1);
         // System.out.println(left+" and "+right);
         // System.out.println(left+" and "+right);
    }else
    {
        Pair curr=new Pair(count,count);
        hm.put(depth,curr);
    }
        
    helper(root.left,2*count,hm,depth+1);
        helper(root.right,2*count+1,hm,depth+1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        HashMap<Integer,Pair> hm=new HashMap<>();
        helper(root,0,hm,0);
        return max;
    }
}