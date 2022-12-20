/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode helper(TreeNode orig,TreeNode clone,TreeNode target)
    {
        if(orig==null) return null;
        if(orig==target) return clone;
        TreeNode left=helper(orig.left,clone.left,target);
        if(left!=null) return left;
        TreeNode right=helper(orig.right,clone.right,target);
        if(right!=null) return right;
        return null;
    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
         return helper(original,cloned,target);
    }
}