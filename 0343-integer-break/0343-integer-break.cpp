class Solution {
public:
    int helper(int n,int m,vector<int> &dp)
    {
        if(n==0)
        {
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int maxm=INT_MIN;
        for(int i=1;n-i>=0;i++)
        {
            if(i==m) continue;
            int rem=helper(n-i,m,dp);
            int ans=i*rem;
            maxm=max(maxm,ans);
        }
        return dp[n]=maxm;
    }
    int integerBreak(int n) {
        vector<int> dp(n+1,-1);
    return helper(n,n,dp);
    }
};