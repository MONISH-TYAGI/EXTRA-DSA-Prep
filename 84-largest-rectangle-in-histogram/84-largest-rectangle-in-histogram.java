class Solution {
    
  public static int []nsr(int []arr)
  {
     int []nse=new int[arr.length];
     Arrays.fill(nse,arr.length);
     Stack<Integer>stk=new Stack<>();
     for(int i=arr.length-1;i>=0;i--)
     {
        while(stk.size()>0 && arr[i]<=arr[stk.peek()])
        {
           stk.pop();
        }
        if(stk.size()>0)
        nse[i]=stk.peek();
        stk.push(i);
        
     }return nse;
  }

  public static int []nsl(int []arr)
  {
     int []nse=new int[arr.length];
     Arrays.fill(nse,-1);
     Stack<Integer>stk=new Stack<>();
     for(int i=0;i<arr.length;i++)
     {
        while(stk.size()>0 && arr[i]<=arr[stk.peek()])
        {
           stk.pop();
        }
        if(stk.size()>0)
        nse[i]=stk.peek();
        stk.push(i);
        
     }
     return nse;
  }

    public int largestRectangleArea(int[] arr) {
      
    int maxArea=0;
    int []nsl=nsl(arr);
    int []nsr=nsr(arr);
   //  int maxArea=0;
    for(int i=0;i<arr.length;i++)
    {
       int currArea=(nsr[i]-nsl[i]-1)*arr[i];
       maxArea=Math.max(maxArea,currArea);
    }
    return maxArea;
  
    }
}