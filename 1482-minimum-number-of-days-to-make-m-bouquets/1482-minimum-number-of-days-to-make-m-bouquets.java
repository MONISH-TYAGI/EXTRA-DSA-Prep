class Solution {
    public static boolean isPossible(int[]arr,long m,long k,long mid)
    {
        long count=0;
        long flowers=0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=mid)
            {
                flowers++;
                if(flowers==k)
                {
                    count++;
                    flowers=0;
                }
            }else
                flowers=0;
        }
        if(count>=m) return true;
        return false;
        
    }
    public int minDays(int[] bloomDay, int m, int k) {
     long  left=1;
        long  right=Integer.MAX_VALUE;
        long ans=right;
        while(left<=right)
        {
            long mid=left+((right-left)/2);
            if(isPossible(bloomDay,(long)m,(long)k,mid)==true)
            {
              ans=mid;
                right=mid-1;
            }else
                left=mid+1;
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return (int)ans;
    }
}