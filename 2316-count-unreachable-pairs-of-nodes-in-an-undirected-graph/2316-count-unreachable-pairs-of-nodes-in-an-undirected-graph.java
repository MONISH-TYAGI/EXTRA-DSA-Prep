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
                        adj[dest].add(src);
        }
    }
        public static void DFS(boolean []vis,Graph g,int src,ArrayList<Integer> obj)
    {
        if(vis[src]==true) return ;
        vis[src]=true;
            obj.add(src);
        for(int nbr:g.adj[src])
            DFS(vis,g,nbr,obj);
    }
    public long countPairs(int n, int[][] edges) {
                
        Graph g=new Graph(n);
        for(int i=0;i<edges.length;i++)
        {
    g.addEdge(edges[i][0],edges[i][1]);
        }
        long count=0;
        boolean []vis=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==false)
            {
ArrayList<Integer> obj=new ArrayList<>();
                DFS(vis,g,i,obj);
                // System.out.println(obj.size());
                count+=(long)(obj.size()*(n*1l-obj.size()));
            }
        }
return count/2;
    }
}