/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
                if(root==null) return "null,";
        return root.val+","+serialize(root.left)+serialize(root.right);
    }
    class Pair{
        TreeNode node;
        char state;
        Pair(TreeNode node,char st)
        {
            this.node=node;
            this.state=st;
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Stack<Pair> stk=new Stack<>();
        String []arr=data.split(",");
        TreeNode root=null;
        for(String curr:arr)
        {
            if(curr.equals("null"))
            {
           if(stk.size()>0&&stk.peek().state=='l')
                {
                    
                    stk.peek().state='r';
                }
                else if(stk.size()>0&&stk.peek().state=='r')
                {
                    stk.pop();
                }   
            }else
            {
                TreeNode node=new TreeNode(Integer.parseInt(curr));
                if(root==null) root=node;
                if(stk.size()>0&&stk.peek().state=='l')
                {
                    stk.peek().node.left=node;
                    stk.peek().state='r';
                }
                else if(stk.size()>0&&stk.peek().state=='r')
                {
                    stk.peek().node.right=node;
                    stk.pop();
                }
                stk.push(new Pair(node,'l'));
            }
            
            
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));