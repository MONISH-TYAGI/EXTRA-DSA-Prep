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

    public void DFS(int src, boolean[] vis,Graph g) {
        if (vis[src] == true)
            return;

        vis[src] = true;

        for (Integer nbr : g.adj[src]) {
            DFS(nbr, vis,g);
        }
    }
}
    public int makeConnected(int n, int[][] isConnected) {
           // int n = isConnected.length;
        if(isConnected.length<n-1) return -1;
        Graph g = new Graph(n);

        // Convert Adjacency Matrix to Adjacency List
        for (int i = 0; i < isConnected.length; i++) {

g.addEdge(isConnected[i][0],isConnected[i][1]);
                
            }
           boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                g.DFS(i, vis,g);
                count++;
            }
        }
 return count-1;  
     }
}