/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<TreeNode> find(TreeNode root,TreeNode target)
    {
        if(root==null) return new ArrayList<>();
        if(root==target)
        {
            List<TreeNode> ans=new ArrayList<>();
            ans.add(root);
            return ans;
        }
        List<TreeNode> left=find(root.left,target);
        if(left.size()>0)
        {
            left.add(root);
            return left;
        }
        
         List<TreeNode> right=find(root.right,target);
        if(right.size()>0)
        {
            right.add(root);
            return right;
        }
        return new ArrayList<>();
    }
    public void kLevelDown(TreeNode root,int k,List<Integer> ans,TreeNode blockage)
    {
        // System.out.println("hello");
       if(k<0||root==null||root==blockage) return ;
        if(k==0)
        {
            ans.add(root.val);
            return ;
        }
            kLevelDown(root.left,k-1,ans,blockage);
        kLevelDown(root.right,k-1,ans,blockage);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<TreeNode> obj=find(root,target);
        List<Integer> ans=new ArrayList<>();
        TreeNode blockage=null;
for(int i=0;i<obj.size();i++)
{
    if(k<0) break;
    TreeNode newRoot=obj.get(i);
    if(i!=0)
     blockage=obj.get(i-1);
    else
         blockage=null;
    kLevelDown(newRoot,k,ans,blockage);
    k--;
}
        return ans;
    }
}