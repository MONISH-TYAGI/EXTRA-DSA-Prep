class Solution {
    class Graph {
    public ArrayList<Integer>[] adj;

    Graph(int n) {
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
    }
            public void addEdge(int src, int dest) {
        adj[src].add(dest);
        adj[dest].add(src);
    }
    }


        public boolean BFS(boolean []vis,Graph g,int src,int dest)
        {
            Queue<Integer> q=new ArrayDeque<>();
            q.add(src);
            
            while(q.size()>0)
            {
              int curr=q.remove();
                if(curr==dest) return true;
                if(vis[curr]==true) continue;
                vis[curr]=true;
                for(int nbr:g.adj[curr])
                {
                    q.add(nbr);
                }
            }
            return false;
        }
    public boolean validPath(int n, int[][] edges, int src, int dest) {
        Graph g=new Graph(n);
        for(int i=0;i<edges.length;i++)
        {
            g.addEdge(edges[i][0],edges[i][1]);
        }
        boolean []vis=new boolean[n];
        return BFS(vis,g,src,dest);
    }
}