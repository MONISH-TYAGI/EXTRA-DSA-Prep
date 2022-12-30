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
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> pq1=new ArrayDeque<>();
        pq1.add(root);
        int level=0;
        while(pq1.size()>0)
        {
        int size=pq1.size();
            int check=(level%2==0)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        for(int i=1;i<=size;i++)
        {
        TreeNode curr=pq1.removeFirst();
            if(level%2==0){
            if(curr.val>check&&curr.val%2==1)
            {
                check=curr.val;
            }else
                return false;
            }else
            {
                if(curr.val<check&&curr.val%2==0)
                {
                    check=curr.val;
                }
                else
                    return false;
            }
            if(curr.left!=null)pq1.add(curr.left);
            if(curr.right!=null)pq1.add(curr.right);
         }
            level++;
        }
        return true;
    }
}