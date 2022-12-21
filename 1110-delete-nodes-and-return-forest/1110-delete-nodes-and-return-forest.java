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
    List<TreeNode> obj=new ArrayList<>();
    public TreeNode helper(TreeNode root,HashSet<Integer> hm)
    {
        if(root==null) return null;
          root.left=helper(root.left,hm);
        root.right= helper(root.right,hm);
        if(hm.contains(root.val)==true)
        {
            if(root.left!=null&&hm.contains(root.left.val)==false)
                obj.add(root.left);
            if(root.right!=null&&hm.contains(root.right.val)==false)
                obj.add(root.right);
            return null;
        }
       return root;
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> hm=new HashSet<>();
        for(int a:to_delete)
            hm.add(a);
        helper(root,hm);
        if(hm.contains(root.val)==false)
            obj.add(root);
        return obj;
    }
}