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
    public boolean find(TreeNode root,TreeNode subRoot)
    {
        if(root==null&&subRoot==null) return true;
        if(root==null||subRoot==null) return false;
        boolean ans1=(root.val==subRoot.val)?true:false;
        if(ans1==false) return false;
        boolean ans2=find(root.left,subRoot.left);
        boolean ans3=find(root.right,subRoot.right);
        return (ans1&&ans2&&ans3);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null) return true;
        if(root==null) return false;
     boolean ans1=find(root,subRoot);
        boolean ans2=isSubtree(root.left,subRoot);
        if(ans2==true) return true;
        boolean ans3=isSubtree(root.right,subRoot);
                if(ans3==true) return true;
        return ans1||ans2||ans3;
    }
}