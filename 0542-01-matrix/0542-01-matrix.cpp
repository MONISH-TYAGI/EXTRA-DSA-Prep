// #define and &&
class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
       int m=mat.size(),n=mat[0].size();
        vector<vector<int>> res(m,vector<int>(n,INT_MAX));
        queue<pair<int,int>> q;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    res[i][j]=0;
                    q.push({i,j});
                }
            }
        }
        // cout<<q.size()<<endl;
        // queue<pair<int,int>> myQueueCopy = q;
        //   while (!myQueueCopy.empty()) {
        // cout << myQueueCopy.front().first << " "<<myQueueCopy.front().second<<" "<<endl;
        // myQueueCopy.pop();
    // }
        vector<pair<int,int>> dirs{{0,1},{1,0},{0,-1},{-1,0}};
        while(q.size()>0)
        {
            auto curr=q.front();
            q.pop();
            int curX=curr.first;
            int curY=curr.second;
            for(auto dir:dirs)
            {
                int x=curX+dir.first;
                int y=curY+dir.second;
                if(x>=0 && x<m && y>=0 && y<n)
                {
                    if(res[x][y]>res[curX][curY]+1)
                    {
                        res[x][y]=res[curX][curY]+1;
                        q.push({x,y});
                    }
                }
            }
        }
        return res;
    }
};
