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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outer=new ArrayList<>();
        if(root==null) return outer;
            //     if(outer.size()==0)
            // outer.add(new ArrayList<>());

        Queue<TreeNode> pq=new ArrayDeque<>();
        pq.add(root);
        while(pq.size()>0)
        {
            List<Integer> inner=new ArrayList<>();
            Queue<TreeNode> pq2=new ArrayDeque<>();
            while(pq.size()>0){
            TreeNode curr=pq.remove();
            inner.add(curr.val);
            if(curr.left!=null)
                pq2.add(curr.left);
            if(curr.right!=null)
                pq2.add(curr.right);
            
            }
            outer.add(inner);
            pq=pq2;
        }
         Collections.reverse(outer);
        return outer;
    }
}