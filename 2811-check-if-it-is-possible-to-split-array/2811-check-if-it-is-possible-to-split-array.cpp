class Solution {
public:
    bool helper(int left,int right,int m,vector<int>&nums,vector<int>&prefix,vector<vector<int>> &dp)
    {
        // cout<<left<<"--"<<right<<endl;
        if(left==right) return true;
        if(dp[left][right]!=-1) 
        {
            if(dp[left][right]==1) return true;
            else return false;
        }
       bool ans=false;
        
        for(int i=left;i<right;i++)
        {
            bool curr1=false,curr2=false,curr=false;
            int lran=i-left+1;
            int rran=right-i;
            bool leftans=false,rightans=false;
            if(lran==1) leftans=true;
            if(prefix[i+1]-prefix[left]>=m)leftans=true;
            if(rran==1)rightans=true;
            if(prefix[right+1]-prefix[i+1]>=m)rightans=true;
            if(leftans==true&&rightans==true)
            {
                // cout<<left<<" "<<i<<" "<<right<<endl;
                curr1=helper(left,i,m,nums,prefix,dp);
                curr2=helper(i+1,right,m,nums,prefix,dp);
            }
           curr=curr1&curr2;
            
            ans=ans|curr;
        }
        
        return  dp[left][right]=ans;
    }
    bool canSplitArray(vector<int>& nums, int m) {
        int left=0,right=nums.size()-1;
        int n=nums.size();
        vector<int> prefix(nums.size()+1);
        vector<vector<int>> dp(n,vector<int>(n,-1));
        prefix[0]=0;
        for(int i=0;i<nums.size();i++)
        {
         prefix[i+1]=prefix[i]+nums[i];   
        }
        return helper(left,right,m,nums,prefix,dp);
    }
};