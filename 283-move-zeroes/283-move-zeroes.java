class Solution {
    public void helper(int idx,int []nums,int countNoOfZeroes)
    {
        if(idx==nums.length)
        {
            int zeroes=nums.length-countNoOfZeroes;
            for(int i=0;i<zeroes;i++)
                nums[nums.length-1-i]=0;
            return ;
        }
        if(nums[idx]!=0)
        {
            nums[countNoOfZeroes]=nums[idx];
            helper(idx+1,nums,countNoOfZeroes+1);
        }else
            helper(idx+1,nums,countNoOfZeroes);
    }
    public void moveZeroes(int[] nums) {
        helper(0,nums,0);
    }
}