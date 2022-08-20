class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]<0||nums[i]>=n+1)
                nums[i]=0;
        }

        for(int i=0;i<nums.length;i++)
        {
            int idx=nums[i]%(n+1);
            if(idx!=0)
            nums[idx-1]=nums[idx-1]+(n+1);
        }   
        for(int i=0;i<nums.length;i++)
        {
        // System.out.print(nums[i]+" ");
            if(nums[i]<(n+1))
                return (i+1);
        } 
        return (n+1);
    }
}