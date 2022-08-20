class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            int idx=nums[i]%(n+1);
            if(idx<n)
            nums[idx]=nums[idx]+(n+1);
        }   
        for(int i=0;i<nums.length;i++)
        {
        // System.out.print(nums[i]+" ");
            if(nums[i]<(n+1))
                return i;
        } 
        return n;

    }
}