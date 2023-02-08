class Solution {
    public boolean isPossible(int cap,int []nums,int k)
    {
        int idx=0;
        while(idx<nums.length)
        {
            if(nums[idx]<=cap)
            {
                k--;
                idx=idx+2;
            }else
                idx++;
        if(k==0) return true;
        }
        return false;
    }
    public int minCapability(int[] nums, int k) {
        int left=1;
        int max=Integer.MIN_VALUE;
        for(int a:nums)
            max=Math.max(a,max);
        int right=max;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(isPossible(mid,nums,k))
            {
                right=mid;
            }else
                left=mid+1;
        }
        return right;
    }
}