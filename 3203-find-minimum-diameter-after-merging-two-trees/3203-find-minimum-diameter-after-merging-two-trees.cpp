class Solution {
public:
    vector<vector<int>> makeGraph(vector<vector<int>>&edges)
    {
        int n=edges.size();
        vector<vector<int>> gr(n+1);
        for(auto edge : edges)
        {
            int u=edge[0],v=edge[1];
            gr[u].push_back(v);
            gr[v].push_back(u); 
        }
        return gr;
    }
    void findFarthest(int node,int par,int dist,vector<vector<int>> &gr,pair<int,int> &res)
    {
        if(dist>res.first)
        {
            res={dist,node};
        }
        for(auto child:gr[node])
        {
            if(child!=par)
            {
                findFarthest(child,node,dist+1,gr,res);
            }
        }
    }
    int minimumDiameterAfterMerge(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        auto gr1=makeGraph(edges1),gr2=makeGraph(edges2);
        pair<int,int> res={INT_MIN,-1},res2={INT_MIN,-1}; //dest,node
        findFarthest(0,-1,0,gr1,res);
        findFarthest(res.second,-1,0,gr1,res2);
        int diameter1=res2.first;
               res={INT_MIN,-1};res2={INT_MIN,-1}; //dest,node
        findFarthest(0,-1,0,gr2,res);
        findFarthest(res.second,-1,0,gr2,res2);
        int diameter2=res2.first;
        return max({diameter1,diameter2,(diameter1+1)/2 +(diameter2+1)/2 +1} );
    }
};