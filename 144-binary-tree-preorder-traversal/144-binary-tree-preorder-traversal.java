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
class Solution {//Through Morris Traversal
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder=new ArrayList<>();
        TreeNode curr=root;
        while(curr!=null)
        {
            if(curr.left==null)
            {
                preOrder.add(curr.val);
                curr=curr.right;
                continue;
            }
            TreeNode rightMost=curr.left;
            while(rightMost.right!=null&&rightMost.right!=curr)
            {
                rightMost=rightMost.right;
            }
            // if(rightMost==null) break;
            if(rightMost.right==null)
            {
                preOrder.add(curr.val);
                rightMost.right=curr;
                curr=curr.left;
            }else
            {
                rightMost.right=null;
                curr=curr.right;
            }
        }
        return preOrder;
    }
}