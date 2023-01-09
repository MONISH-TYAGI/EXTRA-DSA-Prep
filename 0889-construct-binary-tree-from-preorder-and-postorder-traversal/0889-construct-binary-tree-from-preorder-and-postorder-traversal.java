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
    public  int findIdx(int val,int arr[])
    {
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]==val)
            return i;
        }
        return -1;
    }
public  TreeNode helper(int []pre,int []post,int preLeft,int preRight,int postLeft,int postRight){
    if(preLeft>preRight) return null;
    TreeNode curr=new TreeNode(pre[preLeft]);
    if(preLeft==preRight)
    return curr;
    int idx=findIdx(pre[preLeft+1],post);
    curr.left=helper(pre,post,preLeft+1,preLeft+1+(idx-postLeft),postLeft,idx-1);
    curr.right=helper(pre,post,preLeft+1+(idx-postLeft)+1,preRight,idx+1,postRight);
    return curr;
}
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
return helper(pre,post,0,pre.length-1,0,post.length-1);
    }
}