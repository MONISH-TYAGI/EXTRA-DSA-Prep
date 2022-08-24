class Solution {
    public int[] twoSum(int[] nums, int target) {
        //System.out.println("hello");
    HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(target-nums[i])==true)
            {
                int idx=hm.get(target-nums[i]);
                return new int[]{idx,i};
            }else
                hm.put(nums[i],i);
        }
        return nums;
    }
}