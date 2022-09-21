class Solution {
    int operations = 0;
    static class Pair{
        int coins;
        int size;
      Pair()
      {
          coins=0;
          size=0;
      }
    }
    public Pair dfs(TreeNode root){
        if(root==null) return new Pair();
Pair left=dfs(root.left);
        Pair right=dfs(root.right);
        Pair curr=new Pair();
        curr.coins=left.coins+right.coins+root.val;
        curr.size=left.size+right.size+1;
        operations+=Math.abs(curr.coins-curr.size);
        return curr;
    }
    
    public int distributeCoins(TreeNode root) {
        operations = 0;
        dfs(root);
        return operations;
    }
}