class Solution {
public:
    int minCost(string colors, vector<int>& neededTime) {
     int ans=0;
        int n=neededTime.size();
       char lastCh=colors[n-1];
        int val=neededTime[n-1];
        for(int i=n-2;i>=0;i--)
        {
           if(colors[i]==lastCh)
           {
               if(neededTime[i]<val)
               {
                   ans+=neededTime[i];
               }else
               {
                   ans+=val;
                   lastCh=colors[i];
                   val=neededTime[i];
               }
           }else
           {
               lastCh=colors[i];
               val=neededTime[i];
           }
        }
        return ans;
    }
};