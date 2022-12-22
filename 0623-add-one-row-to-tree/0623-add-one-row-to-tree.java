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
    public void helper(TreeNode root,boolean check,TreeNode parent,int depth,int d,int val)
    {

        if(d>depth) return ;
        if(d==depth)
        {
            TreeNode curr=new TreeNode(val);
            if(check==false)
            {
               curr.left=root;
                parent.left=curr; 
                
            }else
            {
                curr.right=root;
                parent.right=curr;
            }
        }
                if(root==null)return ;
        helper(root.left,false,root,depth,d+1,val);
                helper(root.right,true,root,depth,d+1,val);

    }
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
        TreeNode node=new TreeNode(val);
          node.left=root;
            return node;
            }
            
     helper(root,false,null,depth,1,val);  
        return root;
    }
}