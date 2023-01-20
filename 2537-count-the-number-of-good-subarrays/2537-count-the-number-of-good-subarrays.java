class Solution {
    public long countGood(int[] nums, int k) {
     HashMap<Integer,Integer> hm=new HashMap<>();
        int pairs=0;
        long ans=0;
        int j=0;
    for(int i=0;i<nums.length;i++)
    {
        while(pairs<k&&j<nums.length){
        if(hm.containsKey(nums[j])==false)
        {
hm.put(nums[j],1);
        }else
        {
            pairs+=hm.get(nums[j]);
            hm.put(nums[j],hm.get(nums[j])+1);
            
        }
            j++;
        }
        if(pairs>=k)
        {
ans+=nums.length*1l-(j-1)*1l;
    
        }
        int val=hm.get(nums[i]);
        if(hm.get(nums[i])!=0)
    hm.put(nums[i],val-1);
        else
            hm.remove(nums[i]);
        pairs-=val-1;
        
    }
        return ans;
    }
}