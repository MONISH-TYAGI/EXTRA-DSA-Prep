class Solution {
public:
    int helper(int currIdx,vector<int> &arr,int k,vector<int> &dp)
    {
     if(currIdx>=arr.size())
         return 0;
        if(dp[currIdx]!=-1) return dp[currIdx];
        int maxm=INT_MIN;
  int n=arr.size();
        int ans=0;
        for(int start=0;start<k&&currIdx+start<n;start++)
        {
            maxm=max(maxm,arr[currIdx+start]);
            int currSum=maxm*(start+1);
            ans=max(ans,currSum+helper(currIdx+start+1,arr,k,dp));
            
        }
        return dp[currIdx]=ans;
    }
    int maxSumAfterPartitioning(vector<int>& arr, int k) {
        int n=arr.size();
        vector<int> dp(n,-1);
     return helper(0,arr,k,dp);   
    }
};