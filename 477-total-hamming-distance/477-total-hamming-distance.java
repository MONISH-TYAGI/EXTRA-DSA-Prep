class Solution {
    public int totalHammingDistance(int[] nums) {
        int n=nums.length;
        int ans=0;
        for(int i=0;i<32;i++)
        {
            int one=0,zero=0;
            // System.out.println(i);
            
            int k=(1<<i);
            //System.out.println(k);
            for(int j=0;j<n;j++)
            {
                if((nums[j]&k) >= 1)
                {
                    // System.out.println("helllo");
                    one++;
                }
                 else
                    zero++;
            }
            // System.out.println(one+"-"+z);
            if(one==n||zero==n)
                continue;
            else
            ans+=(one*zero);
        }
        return ans;
    }
}