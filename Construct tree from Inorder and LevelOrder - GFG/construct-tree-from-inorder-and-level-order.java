//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node left, right;
    
    Node(int item)
    {
        data = item;
        left = right = null;
    }    
        public void setLeft(Node left) 
    {
        this.left = left;
    }
  
    public void setRight(Node right) 
    {
        this.right = right;
    }
        
    
}


class ConstructBT
{
    Node root;
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- > 0)
	    {
	        int n = sc.nextInt();
	        
	        int inord[] = new int[n];
	        int level[] = new int[n];
	        for(int i = 0; i < n; i++)
	            inord[i] = sc.nextInt();
	            
	        for(int i = 0; i < n; i++)
	             level[i] = sc.nextInt();
	             
	        GfG g = new GfG();
	        Node node =  g.buildTree(inord, level);
	        printPreOrder(node);
	        System.out.println();
	        
	        
	    }
    }
    
   static void printPreOrder(Node node)
   {
       if(node == null)
          return;
          
        System.out.print(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
   }
}

// } Driver Code Ends


/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/*Complete the function below*/
class GfG
{
     public static int findIdx(int arr[],int val)
  {
      for(int i=0;i<arr.length;i++)
      {
          if(arr[i]==val)
          return i;
      }
      return -1;
  }
public static Node helper(int []inorder,int []levelOrder,int inLeft,int inRight)
{
    if(inLeft>inRight) return null;
    Node curr=new Node(levelOrder[0]);
    if(inLeft==inRight) return curr;
    int idx=findIdx(inorder,levelOrder[0]);
    HashSet<Integer> obj=new HashSet<>();
    for(int i=inLeft;i<idx;i++)
    {
        obj.add(inorder[i]);
    }
    int []leftLevelOrder=new int[idx-inLeft];
    int l=0;
    int []rightLevelOrder=new int[inRight-idx];
    int r=0;
    for(int i=1;i<levelOrder.length;i++)
    {
        if(obj.contains(levelOrder[i])==true)
        {
            leftLevelOrder[l++]=levelOrder[i];
            obj.remove(levelOrder[i]);
        }else
        rightLevelOrder[r++]=levelOrder[i];
    }
    curr.left=helper(inorder,leftLevelOrder,inLeft,idx-1);
    curr.right=helper(inorder,rightLevelOrder,idx+1,inRight);
    return curr;
}
  

    Node buildTree(int inord[], int level[])
    {
        //your code here
        return helper(inord,level,0,inord.length-1);
    }
    
   
}


