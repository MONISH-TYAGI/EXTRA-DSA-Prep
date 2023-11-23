class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& nums) {
        map<int,vector<int>> mp;
        int maxm=0;
        for(int i=0;i<nums.size();i++)
        {
            for(int j=0;j<nums[i].size();j++)
            {
                int num=i+j;
                mp[num].push_back(nums[i][j]);
                maxm=max(maxm,i+j);
            }
        }
    vector<int>ans;
        for(int i=0;i<=maxm;i++)
        {
            if(mp[i].size()>0)
            {
                for(int j=mp[i].size()-1;j>=0;j--)
                    ans.push_back(mp[i][j]);
            }
        }
        return ans;
    }
};