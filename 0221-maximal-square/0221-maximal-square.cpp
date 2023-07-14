class Solution {
public:
    int helper(vector<vector<char>>& matrix,int i,int j,vector<vector<int>> &dp)
    {
        int n=matrix.size();
        int m=matrix[0].size();
        if(i<0||j<0||i>=n||j>=m) return 0;
        
        if(dp[i][j]!=-1) return dp[i][j];
        int right=helper(matrix,i,j+1,dp);
        int down=helper(matrix,i+1,j,dp);
        int diag=helper(matrix,i+1,j+1,dp);
        // if(i==n-1&&j==m-1) cout<<right<<" "<<down<<" "<<diag<<endl;
        if(matrix[i][j]!='0'){
            // cout<<dp[i][j]<<" "<<endl;
        return dp[i][j]=min(right,min(down,diag))+1;
        }
        else{ 
             // cout<<dp[i][j]<<" "<<endl;
            return dp[i][j]=0;
            }
    }
    int maximalSquare(vector<vector<char>>& matrix) {
         int n=matrix.size();
        int m=matrix[0].size();
        vector<vector<int>> dp(n,vector<int> (m,-1));
        // for(int i=0;i<n;i++)
        //     fill(arr[i],arr[i]+m,-1);
     helper(matrix,0,0,dp);   
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                ans=max(ans,dp[i][j]);
                // cout<<dp[i][j]<<" ";
            }
            cout<<endl;
        }
        return ans*ans;
    }
};