class Solution {
public:
     int helper(int x,vector<int> &dp)
    {
        if(x==0) return 0;
         if(dp[x]!=-1) return dp[x];
        int minm=INT_MAX;
        for(int i=1;i*i<=x;i++)
        {
            int start=i*i;
            minm=min(minm,1+helper(x-start,dp));
        }
        return dp[x]=minm;
    }
    int numSquares(int n) {
        vector<int> dp(n+1,-1);
        return helper(n,dp);
    }
};