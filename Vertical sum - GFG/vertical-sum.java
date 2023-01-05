//{ Driver Code Starts
//Initial Template for Java

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

class GfG {
    
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
        	    Solution g = new Solution();
			
			    ArrayList <Integer> res = g.verticalSum(root);
			    for (Integer num : res) System.out.print (num + " ");
			    System.out.println();
                t--;
            
        }
    }
  
}


// } Driver Code Ends


/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    static  class Pair{
     Node node;
     int level;
     Pair(Node curr,int x)
     {
         node=curr;
         level=x;
     }
 }

    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Pair> pq=new ArrayDeque<>();
        pq.add(new Pair(root,0));
        int min=0,max=0;
        HashMap<Integer,ArrayList<Integer>> obj=new HashMap<>();
        while(pq.size()>0)
        {
            int size=pq.size();
            while(size-->0)
            {
                Pair curr=pq.remove();
                min=Math.min(curr.level,min);
                max=Math.max(curr.level,max);
                if(obj.containsKey(curr.level)==false)
                obj.put(curr.level,new ArrayList<>());
                obj.get(curr.level).add(curr.node.data);
                if(curr.node.left!=null)pq.add(new Pair(curr.node.left,curr.level-1));
                if(curr.node.right!=null)pq.add(new Pair(curr.node.right,curr.level+1));
            }
        }
        for(int i=min;i<=max;i++)
        {
            int sum=0;
            for(int a:obj.get(i))
            sum+=a;
            ans.add(sum);
        }
        return ans;
    }
}
