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
    public int maxSumMinProduct(int[] nums) {
      int n=nums.length;
        long psum[]=new long[n+1];
        for(int i=0;i<n;i++)
            psum[i+1]=psum[i]+nums[i];
        int []smallerOnLeft=nsl(nums);
        int []smallerOnRight=nsr(nums);
        long max=Long.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int min=nums[i];
            int lr=smallerOnLeft[i];
            int rr=smallerOnRight[i];
            long sum=psum[rr]-psum[lr+1];
            long minProd=min*sum;
            max=Math.max(minProd,max);
        }
        return (int)(max%1000000007);
    }
    
}