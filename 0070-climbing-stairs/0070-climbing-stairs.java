class Solution {
    public int helper(int n,Integer []dp)
    {
        if(n==0||n==1)
            return 1;
        if(dp[n]!=null)return dp[n];
        int left=helper(n-1,dp);
        int right=helper(n-2,dp);
        return dp[n]=left+right;
    }
    public int climbStairs(int n) {
        Integer []dp=new Integer[n+1];
        return helper(n,dp);
    }
}