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
        boolean isBST;
        long min;
        long max;
        
        Pair()
        {
            isBST=false;

        }
        Pair(boolean x)
        {
            isBST=x;
         min =Long.MAX_VALUE;
            max=Long.MIN_VALUE;
        }
    }
    // ArrayList<Integer> obj;
    public Pair helper(TreeNode root)
    {
       
        if(root==null) return new Pair(true);
         // System.out.println("heloo");
        Pair left=helper(root.left);
        Pair right=helper(root.right);
        Pair curr=new Pair();
        if(root.val>left.max&&root.val<right.min)
        {
            if(left.isBST==true&&right.isBST==true)
                curr.isBST=true;
        }
        // if(curr.isBST==false)obj.add(root.val);
        curr.min=Math.min(root.val,Math.min(left.min,right.min));
        curr.max=Math.max(root.val,Math.max(right.max,left.max));
       return curr; 
    }
    public boolean isValidBST(TreeNode root) {
        // obj=new ArrayList<>();
        // System.out.println(obj);

        Pair ans=helper(root);
                // System.out.println(ans.min+" "+ans.max);
        return ans.isBST;
    }
}