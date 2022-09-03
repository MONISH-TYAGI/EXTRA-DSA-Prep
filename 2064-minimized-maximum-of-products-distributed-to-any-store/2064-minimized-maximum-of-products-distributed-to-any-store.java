class Solution {
    public static boolean isPossible(long mid,long n,int[]arr)
    {
       int dist=0;
        for(int i=0;i<arr.length;i++)
        {
            int noOfDist=(int)Math.ceil(arr[i]*1.0/mid*1.0);
            dist+=noOfDist;
        }
        if(dist<=n) return true;
        return false;
        
    }
    public int minimizedMaximum(int n, int[] quantities) {
        long left=1;
        long right=Arrays.stream(quantities).max().getAsInt();
        long ans=right;
        while(left<=right)
        {
            long mid=left+((right-left)/2);
            if(isPossible(mid,n,quantities)==true)
            {
                ans=mid;
                right=mid-1;
            }else
                left=mid+1;
                
        }
        return (int)ans;
    }
}