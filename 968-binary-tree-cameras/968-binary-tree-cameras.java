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
    int camera=0;
    public String DFS(TreeNode root)
    {
        if(root==null) return "covered";
        String left=DFS(root.left);
        String right=DFS(root.right);
        if(left=="need"||right=="need")
        {
            camera++;
            return "camera";
        }
        if(left=="camera"||right=="camera")
        return "covered";
        return "need";
    }
    public int minCameraCover(TreeNode root) {
        String ans=DFS(root);
        if(ans=="need") camera++;
        return camera;
    }
}