class Solution {
public:
    long helper(int currIdx,vector<vector<int>>& pairs,int prev,vector<vector<int>>& dp)
    {
     if(currIdx>=pairs.size()) return 0;
        if(prev!=-1&&dp[currIdx][prev]!=-1) return dp[currIdx][prev];
        long yes=INT_MIN,no=INT_MIN;
     no=helper(currIdx+1,pairs,prev,dp);
    if(prev==-1||pairs[prev][1]<pairs[currIdx][0])
     yes=helper(currIdx+1,pairs,currIdx,dp)+1;
        if(prev!=-1)
            dp[currIdx][prev]=max(yes,no);
    return max(yes,no);
    }
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(),pairs.end());
        int n=pairs.size();
        vector<vector<int>> dp(n,vector<int>(n,-1));
        return (int)helper(0,pairs,-1,dp);
    }
};