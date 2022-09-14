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
    public int helper(TreeNode root,int targetSum,long sum,HashMap<Long,Integer>hm)
    {
        if(root==null) return 0;
        sum+=root.val;
       

        int count=0;
  if(hm.containsKey(sum-targetSum)==true&&hm.get(sum-targetSum)>0)
            count=hm.get(sum-targetSum);
                hm.put(sum,hm.getOrDefault(sum,0)+1);
        count+=helper(root.left,targetSum,sum,hm);
        count+=helper(root.right,targetSum,sum,hm);

    
        hm.put(sum,hm.getOrDefault(sum,0)-1);
            // sum-=root.val;
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null) return 0;
        HashMap<Long,Integer>freq=new HashMap<>();
        freq.put(0l,1);
        return helper(root,targetSum,0l,freq);
        
    }
}