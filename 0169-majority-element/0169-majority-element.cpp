class Solution {
public:
    int majorityElement(vector<int>& nums) {
       unordered_map<int,int> mp;
        for(int a:nums)
            mp[a]++;
        for(auto &ptr:mp)
        {
            if(ptr.second>(nums.size()/2))
                return ptr.first;
        }
        return -1;
    }
};