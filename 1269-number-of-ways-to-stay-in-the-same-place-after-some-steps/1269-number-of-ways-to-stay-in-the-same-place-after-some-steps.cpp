class Solution {
public:
    
    int numWays(int steps, int arrLen) {
    const int MOD=1000000007;
    // int [,]memo=new int[steps+1,Math.min(arrLen,steps)+1];
        vector<vector<int>> memo(steps+1,vector<int>(min(arrLen,steps)+1,-1));
       
            return DP(steps,0,arrLen,MOD,memo);
    }
     int DP(int step,int idx,int arrLen,int MOD,vector<vector<int>> &memo)
    {
        if(step==0)
        {
            return (idx==0)?1:0;
        }
        if(step<0||idx<0||idx>=arrLen)
            return 0;
        if(memo[step][idx]!=-1)
            return memo[step][idx];
        int ways=DP(step-1,idx,arrLen,MOD,memo)%MOD;
        ways=(ways+DP(step-1,idx-1,arrLen,MOD,memo))%MOD;
        ways=(ways+DP(step-1,idx+1,arrLen,MOD,memo))%MOD;
        memo[step][idx]=ways;
        return ways;
    }

};