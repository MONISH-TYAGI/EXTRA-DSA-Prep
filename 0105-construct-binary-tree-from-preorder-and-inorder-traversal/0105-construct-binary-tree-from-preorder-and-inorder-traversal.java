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
    public  TreeNode helper(HashMap<Integer,Integer>hm,int []preorder,int[]inorder,int preLeft,int preRight,int postLeft,int postRight)
{
    if(preLeft>preRight) return null;
    TreeNode node=new TreeNode(preorder[preLeft]);
    int idx=hm.get(preorder[preLeft]);
    node.left=helper(hm,preorder,inorder,preLeft+1,preLeft+idx-postLeft,postLeft,idx-1);
    node.right=helper(hm,preorder,inorder,preLeft+idx-postLeft+1,preRight,idx+1,postRight);
    return node;
}
    public  TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        hm.put(inorder[i],i);
        return helper(hm,preorder,inorder,0,preorder.length-1,0,inorder.length-1);
        
    }
//     public TreeNode buildTree(int[] preorder, int[] inorder) {
        
//     }
}