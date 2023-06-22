class Solution {
public:
    vector<vector<int>> highestRankedKItems(vector<vector<int>>& grid, vector<int>& price, vector<int>& start, int k) {
   int n=grid.size(),m=grid[0].size();
        vector<vector<int>> res;
vector<vector<bool>> v(n,vector<bool> (m,false));
        queue<pair<int,int>> q;
        q.push({start[0],start[1]});
        int dist=0;
         vector<vector<int>>dirs={{1,0},{0,1},{-1,0},{0,-1}};
        while(!q.empty())
        {
            int size=q.size();
            while(size-->0)
            {
                pair curr=q.front();
                q.pop();
                if(v[curr.first][curr.second]==true) continue;
                v[curr.first][curr.second]=true;
                int val=grid[curr.first][curr.second];
                if(val!=1){
                if(val>=price[0]&&val<=price[1])
                {
                    res.push_back({dist,val,curr.first,curr.second});
                }
                }
                for(int i=0;i<dirs.size();i++)
                {
                    int newRow=curr.first+dirs[i][0],newCol=curr.second+dirs[i][1];
                    if(newRow>=0&&newRow<n&&newCol>=0&&newCol<m&&grid[newRow][newCol]!=0)
                        q.push({newRow,newCol});
                }
                
            }
            dist++;
            
        }
        sort(res.begin(),res.end());
        vector<vector<int>> ans;
        for(int i=0;i<min(k,int(res.size()));i++)
            {
                ans.push_back({res[i][2],res[i][3]});
            }
            return ans;
    }
};