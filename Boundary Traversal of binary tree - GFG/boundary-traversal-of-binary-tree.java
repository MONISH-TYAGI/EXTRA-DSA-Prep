//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            
            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution
{
    public void leftSubtree(Node root,ArrayList<Integer>ans)
    {
        if(root==null||(root.left==null&&root.right==null))
        return ;
        ans.add(root.data);
        if(root.left!=null)
        leftSubtree(root.left,ans);
        else
        leftSubtree(root.right,ans);
    }
    public void rightSubtree(Node root,ArrayList<Integer>ans)
    {
        if(root==null||(root.left==null&&root.right==null))
        return ;
        ans.add(root.data);
        if(root.right!=null)
        rightSubtree(root.right,ans);
        else
        rightSubtree(root.left,ans);
    }
    public void leafNodes(Node root,ArrayList<Integer> ans)
    {
        if(root==null) return ;
        if(root.left==null&&root.right==null)
        {
            ans.add(root.data);
            return ;
        }
        leafNodes(root.left,ans);
        leafNodes(root.right,ans);
    }
	ArrayList <Integer> boundary(Node node)
	{
	    ArrayList<Integer> ans=new ArrayList<>();
	    ans.add(node.data);
	    leftSubtree(node.left,ans);
	    leafNodes(node.left,ans);
	    leafNodes(node.right,ans);
	    ArrayList<Integer> rightAns=new ArrayList<>();
	    rightSubtree(node.right,rightAns);
	    Collections.reverse(rightAns);
	    for(int i=0;i<rightAns.size();i++)
	    ans.add(rightAns.get(i));
	    return ans;
	}
}
