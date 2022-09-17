class Solution {
    int mod=1000000007;
    public int helper(int startPos,int endPos,int k,Integer [][]dp)
    {
        if(k<0) return 0;
        if(startPos==endPos&&k==0) return 1;
        
        if(dp[endPos+1001][k]!=null) return dp[endPos+1001][k];
        int left=helper(startPos,endPos-1,k-1,dp)%mod;
        int right=helper(startPos,endPos+1,k-1,dp)%mod;

        return dp[endPos+1001][k]=(left+right)%mod;
        
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        Integer [][]dp=new Integer[3005][k+1];
        return helper(startPos,endPos,k,dp);
    }
}