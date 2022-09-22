class Solution {
    
class Pair{
    TreeNode head;
    TreeNode tail;
    Pair()
    {
        
    }
    Pair(TreeNode x,TreeNode y)
    {
        this.head=x;
        this.tail=y;
    }
}
    public void flatten(TreeNode root) {
       if(root!=null)
           helper(root);
    }
    public Pair helper(TreeNode root)
    {
        if(root.left!=null&&root.right!=null)
        {
         Pair lp=helper(root.left);
            Pair rp=helper(root.right);
            Pair mp=new Pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=lp.head;
            lp.tail.right=rp.head;
            mp.tail=rp.tail;
            return mp;
        }else if(root.left!=null)
        {
         Pair lp=helper(root.left);
            Pair mp=new Pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=lp.head;
            mp.tail=lp.tail;
            return mp;
        }else if(root.right!=null)
        {
            Pair rp=helper(root.right);
            Pair mp=new Pair();
            mp.head=root;
            mp.head.left=null;
            mp.head.right=rp.head;
            mp.tail=rp.tail;
                return mp;
        }
        else
            return new Pair(root,root);
    }
}
