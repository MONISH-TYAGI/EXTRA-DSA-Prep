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
//             for(int j=0;j<n;j++)
//             {
//                 if(i==j) continue;
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
//             maxBomb=max(maxBomb,bomb);
//         }
//         return maxBomb;
//     }
// };
class Solution {
public:
    double calcDis(int& x1, int& y1, int& x2, int& y2){
        
        long double dis = sqrtl(1LL * (x1-x2)*(x1-x2) + 1LL * (y1-y2)*(y1-y2));
        
        return dis;
    }
    
    void dfs(int node, vector<int>& visited,int& thisPathBombs, vector<int> canDetonate[]){
        
        visited[node] = 1;
        thisPathBombs++;
        
        for(int i=0;i<canDetonate[node].size();i++){
            
            int cnode = canDetonate[node][i];
            
            if(visited[cnode] == -1){
                dfs(cnode,visited,thisPathBombs,canDetonate);
            }
        }
    }
    
    int maximumDetonation(vector<vector<int>>& bombs) {
        
        int n = bombs.size();
        
        vector<int> canDetonate[n];
        
        int mxBombs = 0;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double dis = calcDis(bombs[i][0],bombs[i][1],bombs[j][0],bombs[j][1]);
                double d1 = bombs[i][2] * 1.0;
                double d2 = bombs[j][2] * 1.0;
                
                if(dis <= d1){
                    canDetonate[i].push_back(j);
                }
                
                if(dis <= d2){
                    canDetonate[j].push_back(i);
                }
            }
        }
        
        for(int i=0;i<n;i++) {
            int thisPathBombs = 0;
            vector<int> visited(n,-1);
            dfs(i,visited,thisPathBombs,canDetonate);
            mxBombs = max(mxBombs, thisPathBombs);
        }
        
        return mxBombs;
    }
};