class Solution {
    List<TreeNode> nodes;
    HashMap<String,Integer> ans;
        
    public String DFS(TreeNode root){
        if(root==null) return "#";
String currPreOrder=root.val+","+DFS(root.left)+","+DFS(root.right);
    if(ans.containsKey(currPreOrder)==true&&ans.get(currPreOrder)==1)
        nodes.add(root);
        ans.put(currPreOrder,ans.getOrDefault(currPreOrder,0)+1);
        return currPreOrder;
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        nodes=new ArrayList<>();
        ans=new HashMap<>();
        DFS(root);
        return nodes;
    }
}