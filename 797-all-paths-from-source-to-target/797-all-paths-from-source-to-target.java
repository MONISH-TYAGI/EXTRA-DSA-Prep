class Solution {
    public List<List<Integer>> Path;
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
    public void printAllPath(Graph g,ArrayList<Integer> obj,boolean []vis,int src,int dest)
    {
        if(src==dest)
        {
            vis[src]=true;
        obj.add(src);
            Path.add(new ArrayList<>(obj));
            vis[src]=false;
        obj.remove(obj.size()-1);
            return ;
        }
        if(vis[src]==true) return ;
        vis[src]=true;
        obj.add(src);
        for(int nbr:g.adj[src])
        {
            printAllPath(g,obj,vis,nbr,dest);
        }
        vis[src]=false;
        obj.remove(obj.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Path=new ArrayList<>();
    Graph g=new Graph(graph.length);
       for(int i=0;i<graph.length;i++)
       {
           for(int nbr:graph[i])
           {
               g.adj[i].add(nbr);
           }
       }
        boolean []vis=new boolean[graph.length];
    printAllPath(g,new ArrayList<>(),vis,0,graph.length-1);
        return Path;
    }
}