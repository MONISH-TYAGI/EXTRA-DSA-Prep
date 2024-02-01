class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& temperatures) {
           stack<pair<int,int>> stk;
        int n=temperatures.size();
        vector<int> ans(n,0);
        // fill(ans,ans+n,0);
        for(int i=0;i<temperatures.size();i++)
        {
            int temp=temperatures[i];
            while(stk.size()>0&&stk.top().first<temp)
            {
                ans[stk.top().second]=i-stk.top().second;
                stk.pop();
            }
            pair<int,int> latest;
            latest.first=temp;
            latest.second=i;
            stk.push(latest);
            
        }
        return ans;
    }
};