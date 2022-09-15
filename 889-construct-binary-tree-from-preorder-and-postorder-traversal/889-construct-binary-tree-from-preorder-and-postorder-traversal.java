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
    public int find(int []arr,int x)
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==x) return i;
        }
        return -1;
    }
    public TreeNode helper(int []preorder,int []postorder,int preLeft,int preRight,int posLeft,int postRight)
    {
        if(preLeft>preRight) return null;
         if(preLeft==preRight) return new TreeNode(preorder[preLeft]);
        TreeNode node=new TreeNode(preorder[preLeft]);
       
        if(preLeft+1>=preorder.length) return node;
        int leftChild=preorder[preLeft+1];
        int postIdx=find(postorder,leftChild);
        int leftCount=postIdx-posLeft+1;
        node.left=helper(preorder,postorder,preLeft+1,preLeft+leftCount,posLeft,postIdx);
        node.right=helper(preorder,postorder,preLeft+leftCount+1,preRight,postIdx+1,postRight-1);
        return node;
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }
}