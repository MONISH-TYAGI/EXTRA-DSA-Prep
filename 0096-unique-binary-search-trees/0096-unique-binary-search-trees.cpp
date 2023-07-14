class Solution {
public:
    int helper(int x,int dp[])
    {
        if(x==1||x==0) return dp[x]=1;
        if(x==2) return dp[x]=2;
        if(dp[x]!=-1) return dp[x];
        int ans=0;
        for(int i=1;i<=x;i++)
        {
            ans=ans+(helper(i-1,dp)*helper(x-i,dp));
        }
        return dp[x]=ans;
    }
    int numTrees(int n) {
       int dp[n+1];
        fill(dp,dp+(n+1),-1);
        helper(n,dp);
        return dp[n];
    }
};