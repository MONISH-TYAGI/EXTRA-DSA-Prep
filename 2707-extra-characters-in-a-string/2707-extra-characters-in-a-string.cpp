class Solution {
public:
    int helper(string s,int idx,unordered_set<string> &check,vector<int>&dp)
    {
        if(idx>=s.length()) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int notTake=INT_MAX,take=INT_MAX;
        notTake=helper(s,idx+1,check,dp)+1;
        int mini=INT_MAX;
        for(int i=1;idx+i<=s.length();i++)
        {
             string sub=s.substr(idx,i);
            if(check.find(sub)!=check.end())
            {
                take=helper(s,idx+i,check,dp);
                mini=min(take,mini);
            }
        }
        return dp[idx]= min(mini,notTake);
    }
    int minExtraChar(string s, vector<string>& dictionary) {
        unordered_set<string> check;
        for(string a:dictionary)
            check.insert(a);
        vector<int> dp(s.length()+1,-1);
        return helper(s,0,check,dp);
    }
};