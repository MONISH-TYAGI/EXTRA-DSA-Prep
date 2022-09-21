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
    int idx=0;
    public TreeNode helper(int []arr,int min,int max)
    {
        if(idx==arr.length) return null;

        if(min<arr[idx]&&arr[idx]<max)
        {

            TreeNode curr=new TreeNode(arr[idx]);
                            idx++;
            curr.left=helper(arr,min,arr[idx-1]);
                curr.right=helper(arr,arr[idx-1],max);
            return curr;
        }else
             return null;
        
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}