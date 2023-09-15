class Solution {
public:
    void dfs(string first,unordered_map<string, priority_queue<string, vector<string>, greater<string>>> & mp,vector<string> &ans)
    {
        while(mp[first].size()>0)
        {
      string nbr=mp[first].top();
            mp[first].pop();
            dfs(nbr,mp,ans);
        }
        ans.push_back(first);
    }
    vector<string> findItinerary(vector<vector<string>>& tickets) {
      unordered_map<string, priority_queue<string, vector<string>, greater<string>>> mp;
        for(int i=0;i<tickets.size();i++)
        {
   vector<string> curr=tickets[i];
            if(mp.find(curr[0])==mp.end())
               {
                   priority_queue<string, vector<string>, greater<string>> temp;
                   mp[curr[0]]=temp;    
               }
               if(mp.find(curr[1])==mp.end())
               {
                   priority_queue<string, vector<string>, greater<string>> temp;
                   mp[curr[1]]=temp;
               }
               mp[curr[0]].push(curr[1]);
        }
    vector<string> ans;
        dfs("JFK",mp,ans);
        reverse(ans.begin(),ans.end());
               return ans;
    }
};