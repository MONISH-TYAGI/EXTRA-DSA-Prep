class Solution {
        public static boolean canAllocate(int []arr,int mid,int k)
    {
        int currPages=0;
        int count=0;
        for(int i=0;i<arr.length;i++)
        {
            if(currPages+arr[i]<=mid)
            {
                currPages+=arr[i];
            }
            else
            {
                currPages=arr[i];
                count++;
            }
            if(count>=k) return false;
        }
        return true;
    }
    public static int findHigh(int []arr)
    {
        int sum=0;
        for(int a:arr)
        sum+=a;
        return sum;
    }
public static int findLow(int []arr)
{
    int max=Integer.MIN_VALUE;
    for(int a:arr)
    max=Math.max(max,a);
    return max;
}
    public int splitArray(int[] arr, int m) {
        int left=findLow(arr);
    // System.out.println(left);
    int right=findHigh(arr);
    // System.out.println(right);
    int ans=right;
    while(left<=right)
    {
        int mid=left+((right-left)/2);
        if(canAllocate(arr,mid,m)==true)
        {
            ans=mid;
            right=mid-1;
        }else
        left=mid+1;
    }
    return ans;
    }
}