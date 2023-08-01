class Solution {
public:
    long helper(int first,int second,string &s1,string &s2,vector<vector<int>> &dp)
    {
        if(first>=s1.length()&&second>=s2.length())
        {
            return 0;
        }
        if(dp[first][second]!=-1)
            return dp[first][second];
         int fval=INT_MAX,sval=INT_MAX;
        if(first<s1.length()&&second<s2.length()&&s1[first]==s2[second])
            return dp[first][second]= helper(first+1,second+1,s1,s2,dp);
      
        else
        {
            if(first<s1.length())
           fval=(int)(s1[first])+ helper(first+1,second,s1,s2,dp);
            if(second<s2.length())
           sval=(int)(s2[second])+ helper(first,second+1,s1,s2,dp);
        }
        return dp[first][second]=min(fval,sval);
    }
    int minimumDeleteSum(string s1, string s2) {
        string ans="";
        // int minm=INT_MAX;
        vector<vector<int>> dp(s1.length()+1,vector<int>(s2.length()+1,-1));
         return (int)(helper(0,0,s1,s2,dp));
        // cout<<"min->"<<minm<<endl;
        // cout<<ans<<endl;
        // return minm;
    }
};