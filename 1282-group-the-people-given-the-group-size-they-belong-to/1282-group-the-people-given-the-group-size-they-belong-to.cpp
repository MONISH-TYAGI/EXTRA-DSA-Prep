class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        unordered_map<int,vector<int>> mp;
        vector<vector<int>> arr;
        for(int i=0;i<groupSizes.size();i++)
        {
            int size=groupSizes[i];
            mp[groupSizes[i]].push_back(i);
            if(mp[groupSizes[i]].size()==size)
            {
                arr.push_back(mp[groupSizes[i]]);
                mp[groupSizes[i]].clear();
            }
        }
        return arr;
    }
};