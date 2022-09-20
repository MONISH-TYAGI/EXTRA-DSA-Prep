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
    public String DFS(TreeNode root,HashMap<String,Integer>hm,List<TreeNode> ans)
    {
        if(root==null) return "#";
        String currPreOrder=root.val+","+DFS(root.left,hm,ans)+","+DFS(root.right,hm,ans);
     if(hm.containsKey(currPreOrder)==true&&hm.get(currPreOrder)==1)
            ans.add(root);
        hm.put(currPreOrder,hm.getOrDefault(currPreOrder,0)+1);
        return currPreOrder;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans=new ArrayList<>();
        HashMap<String,Integer>hm=new HashMap<>();
        DFS(root,hm,ans);
        return ans;
    }
}