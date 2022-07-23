class Solution {
    long findMaxSubarraySum(int arr[], int N,int X)
    {
        if(X<=1)
            return 0;
        // Your code goes here
        long sum=1;
        long maxSum=0;
        int left=0;
        for(int i=0;i<arr.length;i++)
        {
            sum*=arr[i];
            while(sum>=X)
            {
                sum/=arr[left];
                left++;
            }
            maxSum+=i-left+1;
        }
        return (int)maxSum;
    }
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return (int)findMaxSubarraySum(nums,nums.length,k);
    }
}