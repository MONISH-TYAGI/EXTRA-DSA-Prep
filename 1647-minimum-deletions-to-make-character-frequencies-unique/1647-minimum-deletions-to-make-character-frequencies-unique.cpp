class Solution {
public:
    int minDeletions(string s) {
     
        unordered_map<char,int> mp;
        for(int i=0;i<s.length();i++)
            mp[s[i]]++;
        vector<int> v;
        for(auto it:mp)
        {
        v.push_back(mp[it.first]);
        }
        sort(v.rbegin(),v.rend());
        unordered_set<int> set;
        int sum=0;
        for(int i=0;i<v.size();i++)
        {
            while(v[i]>0&&set.find(v[i])!=set.end())
            {
                v[i]--;
                sum++;
            }
            if(v[i]>0)
                set.insert(v[i]);
            
        }
        return sum;
    }
};