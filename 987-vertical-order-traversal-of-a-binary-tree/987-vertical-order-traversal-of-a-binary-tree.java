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
    public void DFS(TreeNode root,int row,int col)
    {
        if(root==null) return ;
        if(vertical.containsKey(col)==false)
            vertical.put(col,new TreeMap<>());
        if(vertical.get(col).containsKey(row)==false)
            vertical.get(col).put(row,new ArrayList<>());
        vertical.get(col).get(row).add(root.val);
        DFS(root.left,row+1,col-1);
        DFS(root.right,row+1,col+1);
    }
    TreeMap<Integer,TreeMap<Integer,ArrayList<Integer>>>vertical;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        vertical=new TreeMap<>();
        DFS(root,0,0);
    List<List<Integer>>obj=new ArrayList<>();
        for(Integer col:vertical.keySet())
        {
    TreeMap<Integer, ArrayList<Integer>> curr = vertical.get(col);

            List<Integer> subans=new ArrayList<>();
            for(Integer row:curr.keySet())
            {
                ArrayList<Integer> abc=curr.get(row);
                Collections.sort(abc);
                for(Integer val:abc)
                    subans.add(val);
            }
            obj.add(subans);
        }
        return obj;
    }
}