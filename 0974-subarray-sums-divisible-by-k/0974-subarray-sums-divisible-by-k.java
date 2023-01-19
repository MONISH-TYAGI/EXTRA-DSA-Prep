class Solution {
    public int subarraysDivByK(int[] nums, int k) {
HashMap<Integer,Integer> hm=new HashMap<>();
        int []preSum=new int[nums.length];
        preSum[0]=nums[0];
        for(int i=1;i<nums.length;i++)
            preSum[i]=preSum[i-1]+nums[i];
        int  count=0;
        hm.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            int val=(preSum[i]%k+k)%k;
            count+=hm.getOrDefault(val,0);
            hm.put(val,hm.getOrDefault(val,0)+1);
        }
        return count;
    }
}
