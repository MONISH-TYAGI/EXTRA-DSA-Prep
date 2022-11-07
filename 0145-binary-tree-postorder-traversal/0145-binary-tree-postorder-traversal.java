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
    
    public void helper(TreeNode root,List<Integer> obj)
    {
        if(root==null) return ;
                helper(root.left,obj);
        helper(root.right,obj);

        obj.add(root.val);
        
    }
    public List<Integer> postorderTraversal(TreeNode root) {
List<Integer> obj=new ArrayList<>();
         helper(root,obj);
        return obj;
    }
}