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
    public TreeNode helper(int []preorder,HashMap<Integer,Integer>hm,int inLeft,int inRight,int preLeft,int preRight)
    {
        if(inLeft>inRight) return null;
        TreeNode node=new TreeNode(preorder[preLeft]);
        int idx=hm.get(preorder[preLeft]);
node.left=helper(preorder,hm,inLeft,idx-1,preLeft+1,preLeft+idx-inLeft);
        node.right=helper(preorder,hm,idx+1,inRight,preLeft+idx-inLeft+1,preRight);
            return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            hm.put(inorder[i],i);
        }
        return helper(preorder,hm,0,inorder.length-1,0,preorder.length-1);
    }
}