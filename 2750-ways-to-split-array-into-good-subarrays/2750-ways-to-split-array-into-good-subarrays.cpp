class Solution {
public:
    int numberOfGoodSubarraySplits(vector<int>& nums) {
       long mod=1000000007;
        long ans=1;
        int i=0;
        int n=nums.size();
        while(i<n&&nums[i]==0)
            i++;
        if(i==n) return 0;
        long count=0;
        for(;i<n;i++)
        {
            if(nums[i]==0)
                count++;
            else
            {
                ans=(ans%mod*(count+1)%mod)%mod;
                count=0;
            }
            
        }
        // if(count!=0)
        //  ans=(ans%mod*(count)%mod)%mod;
        return (int)(ans%mod);
                   }
};