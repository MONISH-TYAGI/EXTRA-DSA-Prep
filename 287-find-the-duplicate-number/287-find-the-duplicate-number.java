class Solution {
    public int findDuplicate(int[] nums) {
                int n=nums.length;
        for(int i=0;i<nums.length;i++)
        {
            int idx=nums[i]%(n+1);
            if(idx-1<n)
            nums[idx-1]=nums[idx-1]+(n+1);
        }   
        for(int i=0;i<nums.length;i++)
        {
        // System.out.print(nums[i]+" ");
            if(nums[i]/(n+1)>1)
                return i+1;
        } 
        return n;
    }
}