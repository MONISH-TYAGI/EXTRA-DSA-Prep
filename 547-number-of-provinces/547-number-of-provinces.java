class Solution {
        public class Graph{
        ArrayList<Integer> []adj;
        Graph(int n)
        {
            adj=new ArrayList[n];
            for(int i=0;i<n;i++)
                adj[i]=new ArrayList<>();
        }
        public void addEdge(int src,int dest)
        {
            adj[src].add(dest);
            
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        Graph g=new Graph(isConnected.length);
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[0].length;j++)
            {
                if(i!=j&&isConnected[i][j]==1)
                    g.addEdge(i,j);
            }
        }
        int count=0;
        boolean []vis=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
                count++;
                DFS(vis,g,i);
            }
        }
return count;
    }
    public static void DFS(boolean []vis,Graph g,int src)
    {
        if(vis[src]==true) return ;
        vis[src]=true;
        for(int nbr:g.adj[src])
            DFS(vis,g,nbr);
    }
}