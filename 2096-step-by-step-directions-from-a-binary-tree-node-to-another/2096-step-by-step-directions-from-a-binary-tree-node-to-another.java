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
    public ArrayList<TreeNode> getPath(TreeNode root,int val)
    {
        if(root==null) return new ArrayList<>();
        if(root.val==val)
        {
            ArrayList<TreeNode> obj=new ArrayList<>();
            obj.add(root);
            return obj;
        }
        ArrayList<TreeNode> left=getPath(root.left,val);
        if(left.size()>0)
        {
            left.add(root);
            return left;
        }
        ArrayList<TreeNode> right=getPath(root.right,val);
                if(right.size()>0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
    public String getDirections(TreeNode root, int startValue, int destValue) {
        ArrayList<TreeNode> l1=getPath(root,startValue);
        ArrayList<TreeNode> l2=getPath(root,destValue);
        StringBuilder res=new StringBuilder();
        // System.out.println(l1);
        //         System.out.println(l2);
        int i=l1.size()-1,j=l2.size()-1;
        while(i>=0&&j>=0)
        {
            if(l1.get(i).val==l2.get(j).val)
            {
                i--;
                j--;
            }else break;
        }
        i++;
        j++;
        for(int k=1;k<=i;k++)
        {
            res.append("U");
        }
        for(int k=j;k>0;k--)
        {
            if(l2.get(k).right==l2.get(k-1))
                res.append("R");
            else if(l2.get(k).left==l2.get(k-1))
                res.append("L");
        }
        return res.toString();
    }
}