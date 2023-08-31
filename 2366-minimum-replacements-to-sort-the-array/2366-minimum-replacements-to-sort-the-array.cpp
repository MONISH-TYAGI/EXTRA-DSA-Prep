class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
   int last=nums[nums.size()-1];
        int n=nums.size();
        long long ans=0;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<=last)
            {
                last=nums[i];
                
            }else
            {
                long long noOfCells=nums[i]*1ll/last*1ll;
                if(nums[i]%last!=0) noOfCells++;
                ans+=noOfCells-1;
                int val=nums[i]/noOfCells;
                last=val;
            }
        }
        return ans;
    }
};