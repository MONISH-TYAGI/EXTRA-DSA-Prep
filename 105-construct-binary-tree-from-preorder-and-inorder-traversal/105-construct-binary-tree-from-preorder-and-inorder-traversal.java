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

    public TreeNode helper(int []preorder,int []inorder,int left,int right,HashMap<Integer,Integer> hm,int preIdx)
    {
        if(left>right) return null;
        TreeNode node=new TreeNode(preorder[preIdx]);
        if(left==right)
        {
            node.left=null;
            node.right=null;
            return node;
        }
        int inIdx=hm.get(preorder[preIdx]);
        node.left=helper(preorder,inorder,left,inIdx-1,hm,preIdx+1);
        node.right=helper(preorder,inorder,inIdx+1,right,hm,preIdx+(inIdx-left)+1);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0;i<inorder.length;i++)
        {
            hm.put(inorder[i],i);
        }
        
TreeNode ans= helper(preorder,inorder,0,preorder.length-1,hm,0);
        return ans;
        // TreeNode curr=ans;
        // while(curr!=null);
        // {
        //     System.out.println(curr.val);
        //     curr=curr.right;
        // }
        // return ans;
    }
}