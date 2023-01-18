class Solution {
    public int maxSubarraySumCircular(int[] nums) {
 int currSum=nums[0];
        int currSum2=nums[0];
        int minSum=nums[0];
        int maxSum=nums[0];
        int total=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            if(currSum+nums[i]>nums[i])
                currSum+=nums[i];
            else
                currSum=nums[i];
            maxSum=Math.max(maxSum,currSum);
            
            if(currSum2+nums[i]<nums[i])
                currSum2+=nums[i];
            else
                currSum2=nums[i];
            minSum=Math.min(minSum,currSum2);
            
            total = total + nums[i];

        }
        System.out.println("maxSum"+maxSum);
        System.out.println("total"+total);
        System.out.println("minSum"+minSum);
        if (maxSum < 0)
            return maxSum;
        return Math.max(maxSum, total - minSum);
    }
}