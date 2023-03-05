class Solution {
    public int minimizeSum(int[] nums) {
        if(nums.length==3) return 0;
        Arrays.sort(nums);
        //when first two = third smallest
        int ans1=Math.abs(nums[nums.length-1]-nums[2]);
        //when last two=third largest
        // if(nums.length>=4)
        int ans2=Math.abs(nums[nums.length-3]-nums[0]);
        int ans3=Math.abs(nums[nums.length-2]-nums[1]);
        return Math.min(Math.min(ans1,ans2),ans3);
    }
}