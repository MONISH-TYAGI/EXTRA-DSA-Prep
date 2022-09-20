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
        int yes;
        int no;
        Pair(int x,int y)
        {
            yes=x;
            no=y;
        }
    }
    public Pair DFS(TreeNode root)
    {
        if(root==null) return new Pair(0,0);
        Pair left=DFS(root.left);
        Pair right=DFS(root.right);
        int no=left.yes+right.yes;
        int yes=Math.max(no,root.val+left.no+right.no);
        return new Pair(yes,no);
    }
    public int rob(TreeNode root) {
    Pair ans=DFS(root);
        return Math.max(ans.yes,ans.no);
    }
}