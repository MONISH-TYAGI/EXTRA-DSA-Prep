//{ Driver Code Starts
//Initial template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            String line = br.readLine();
            String[] splitLine = line.split(" ");
            int nd1 = Integer.parseInt(splitLine[0]);
            int nd2 = Integer.parseInt(splitLine[1]);
            int turn;

            Solution ob = new Solution();
            if((turn = ob.NumberOfTurns(root, nd1, nd2)) != 0)
              System.out.println(turn);
            else
              System.out.println("-1");
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java
/*
Node defined as
class Node{
    int data;
    Node left,right;
    Node(int d){
        data=d;
        left=right=null;
    }
}
*/
class Solution
{
    static int x,y;
    static void count(Node root,int first,int second,int dir,boolean check,int turns)
    {
        if(root==null) return;
        if(root.data==first||root.data==second)
        {
            if(check==true)
            x=turns;
            else
            y=turns;
            return ;
        }
        if(dir==0)
        {
            count(root.left,first,second,0,check,turns);
            count(root.right,first,second,1,check,turns+1);
        }else
        {
            count(root.left,first,second,0,check,turns+1);
            count(root.right,first,second,1,check,turns);
        }
    }
    static int NumberOfTurns(Node root, int first, int second)
    {
        //your code here
        x=y=0;
        Node lca=findLCA(root,first,second);
        count(lca.left,first,second,0,true,0);
        count(lca.right,first,second,1,false,0);
        
        if(lca.data==first||lca.data==second)
        {
            return x+y;
        }else
        return x+y+1;
    }
    static Node findLCA(Node root,int first,int second)
    {
        if(root==null)
        return null;
        if(root.data==first||root.data==second)
        return root;
        Node left_lca=findLCA(root.left,first,second);
        Node right_lca=findLCA(root.right,first,second);
        if(left_lca!=null&&right_lca!=null)
        return root;
        else
        return left_lca==null?right_lca:left_lca;
    }
}