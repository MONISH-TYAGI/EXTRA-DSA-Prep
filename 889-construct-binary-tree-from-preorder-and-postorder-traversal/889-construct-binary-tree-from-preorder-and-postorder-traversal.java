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
        if(preRight<preLeft)return null;
       if(preLeft>=preorder.length)return null;
       TreeNode curr=new TreeNode(preorder[preLeft]);
         if(preLeft==preRight) return curr;
        // if(preLeft+1==preorder.length) return null;
        int idx=find(postorder,preorder[preLeft+1]);
        int leftCount=idx-posLeft+1;
        curr.left=helper(preorder,postorder,preLeft+1,preLeft+leftCount,posLeft,idx);
        curr.right=helper(preorder,postorder,preLeft+leftCount+1,preRight,idx+1,preRight-1);
        return curr;
        
    }
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return helper(preorder,postorder,0,preorder.length-1,0,postorder.length-1);
    }
}