/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    class Pair{
        Node node;
        int state=-1;
        Pair(Node x)
        {
            node=x;
        }
    }
    public List<Integer> preorder(Node root) {
    
        Stack<Pair> stk=new Stack<>();
        List<Integer> pre=new ArrayList<>();
        if(root==null) return pre;
        stk.push(new Pair(root));
        while(stk.size()>0)
        {
            Pair top=stk.peek();
            if(top.state==-1)
            {
                pre.add(top.node.val);
                top.state++;
            }
            else if(top.state==top.node.children.size())
            {
                stk.pop();
            }
            else
            {
                stk.push(new Pair(top.node.children.get(top.state)));
                top.state++;
            }
            
        }
        return pre;
    }
}