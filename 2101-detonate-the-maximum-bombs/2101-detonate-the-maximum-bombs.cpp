// #define ll long long int
// class Solution {
// public:
//     void dfs(int curr,int& bomb,vector<int>& check,vector<vector<int>> canDestroy)
//     {
//         check[curr]=1;
//         bomb++;
//         for(int i=0;i<canDestroy[curr].size();i++)
//         {
//             int val=canDestroy[curr][i];
//             if(check[val]==-1)
//                 dfs(val,bomb,check,canDestroy);
//         }
//     }
//     int maximumDetonation(vector<vector<int>>& bombs) {
//         int n=bombs.size();
//         vector<vector<int>> canDestroy(n);
//         for(int i=0;i<n;i++)
//         {
//             for(int j=i+1;j<n;j++)
//             {
//                 // if(i==j) continue
//                 long double xsq=bombs[i][0]*1.0-bombs[j][0]*1.0;
//                 xsq=xsq*xsq;
//                long double ysq=bombs[i][1]-bombs[j][1];
//                 ysq=ysq*ysq*1.0;
//                long double r1=bombs[i][2]*1l*bombs[i][2]*1.0;
//                long double r2=bombs[j][2]*1l*bombs[j][2]*1.0;
//                long double dis=xsq+ysq;
//                 if(dis<=r1)
//                     canDestroy[i].push_back(j);
//                 if(dis<=r2)
//                     canDestroy[j].push_back(i);
                
//             }                
//         }

//         // for(int i=0;i<n;i++)
//         // {
//         //     cout<<i<<" "<<endl;
//         //     for(int j=0;j<canDestroy[i].size();j++)
//         //         cout<<canDestroy[i][j]<<" ";
//         //     cout<<endl;
//         // }
//         int maxBomb=0;
//         for(int i=0;i<n;i++)
//         {
//             int bomb=0;
//             vector<int> check(n,-1);
//             dfs(i,bomb,check,canDestroy);
            
//             cout<<bomb<<endl;
         
//             maxBomb=max(maxBomb,bomb);
//                // if(bomb==n)break;
//         }
//         return maxBomb;
//     }
// };
class Solution {
#define ll long long int
    public:
    void dfs(vector<vector<int>> &graph,vector<bool> &visited,int &c,int &i)
    {
        visited[i]=true;
        c++;
        for(int j=0;j<graph[i].size();j++)
        {
            if(!visited[graph[i][j]])
             dfs(graph,visited,c,graph[i][j]);   
        }
    }
    int maximumDetonation(vector<vector<int>>& bombs) {

        int n=bombs.size();
        vector<vector<int> > graph(n);
        for(int i=0;i<n;i++)
        {
            ll x1,y1,r1;
            x1=bombs[i][0];
            y1=bombs[i][1];
            r1=bombs[i][2];
            for(int j=0;j<n;j++)
            {
                if(i!=j)
                {
                     ll x2,y2,r2;
                     x2=abs(x1-bombs[j][0]);
                     y2=abs(y1-bombs[j][1]);
                    if(x2*x2+y2*y2<=r1*r1)
                    {
                        graph[i].push_back(j);
                    }
                }
            }
        }
        int ans=INT_MIN;
        for(int i=0;i<n;i++)
        {
            int c=0;
            vector<bool> visited(n,false);
            dfs(graph,visited,c,i);
            ans=max(ans,c);
        }
        return ans;
    }
};