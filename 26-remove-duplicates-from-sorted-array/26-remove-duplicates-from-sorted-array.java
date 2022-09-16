class Solution {
    public int removeDuplicates(int[] nums) {
      int idx=0;
        HashSet<Integer> obj=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(obj.contains(nums[i])==false)
                nums[idx++]=nums[i];
            obj.add(nums[i]);
        }
        return idx;
    }
}