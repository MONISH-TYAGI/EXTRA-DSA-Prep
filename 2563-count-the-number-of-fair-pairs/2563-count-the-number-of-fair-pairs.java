class Solution {
    public int findlowerBound(ArrayList<Integer> obj,int val)
    {
        
        int low=0;
        int high=obj.size()-1;
        while(low<high)
        {
            int mid=low+((high-low)/2);

             if(obj.get(mid)<val)
            {
                low=mid+1;
            }else
                high=mid;
        }
        if(low>=0&&low<obj.size()&&obj.get(low)>=val)
            return low;
        return obj.size();
    }
        public int findUpperBound(ArrayList<Integer> obj,int val)
    {
            
         
        int low=0;
        int high=obj.size()-1;
        while(low<=high)
        {
            int mid=low+((high-low)/2);
         
             if(obj.get(mid)<=val)
            {
                low=mid+1;
            }else
                high=mid-1;
        }
        if(low>=0&&low<obj.size()&&obj.get(low)>val)
            return low;
        return obj.size();
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        ArrayList<Integer> obj=new ArrayList<>();
        obj.add(nums[0]);
        int n=nums.length;
        if(n==1) return 0;
        long ans=0;
        for(int i=1;i<nums.length;i++)
        {
            int lowerLimit=lower-nums[i];
            int higherLimit=upper-nums[i];
            int lowIdx=findlowerBound(obj,lowerLimit);
            int highIdx=findUpperBound(obj,higherLimit);
            ans+=highIdx-lowIdx;
            obj.add(nums[i]);
            // Collections.sort(obj);
            // System.out.println(nums[i]+" and i-> "+lowIdx+" and "+highIdx);
        
    }
        return ans;
}
}