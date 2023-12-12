class Solution {
public:
    int findSpecialInteger(vector<int>& arr) {
        unordered_map<int,int> mp;
        for(int a:arr)
        {
            mp[a]++;
        }
    int n=arr.size();
        for(auto a:mp)
        {
            if(a.second>(n/4))
                return a.first;
        }
        return -1;
    }
};