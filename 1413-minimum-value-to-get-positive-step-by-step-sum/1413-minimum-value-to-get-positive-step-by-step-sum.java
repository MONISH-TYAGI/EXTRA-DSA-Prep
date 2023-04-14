class Solution {
    public int minStartValue(int[] nums) {
    int []prefixSum=new int[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int startValue=1;
        for(int i=0;i<prefixSum.length;i++)
        {
            if(startValue+prefixSum[i]<1)
            {
                startValue=startValue+Math.abs(startValue+prefixSum[i])+1;
            }
        }
        return startValue;
    }
}