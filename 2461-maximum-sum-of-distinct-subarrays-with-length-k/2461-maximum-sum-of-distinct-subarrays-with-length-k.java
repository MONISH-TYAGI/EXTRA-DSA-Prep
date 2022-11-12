class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        long sum=0;
        long max=0;
        for(int i=0;i<k;i++)
        {
            sum+=nums[i];
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
        if(hm.size()==k)
            max=Math.max(max,sum);
        for(int i=k;i<nums.length;i++)
        {
            sum=(sum-nums[i-k])+nums[i];
            hm.put(nums[i-k],hm.getOrDefault(nums[i-k],0)-1);
            if(hm.get(nums[i-k])==0)
                hm.remove(nums[i-k]);
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            if(hm.size()==k)
            max=Math.max(max,sum);
            
        }
        return max;
    }
}