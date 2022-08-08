class Solution {
    List<List<Integer>> obj;
    int []parent;
    int []disc;
    int []low;
    int count=-1;
    public void DFS(int src,  ArrayList<Integer>[] adj)
    {
        count++;
      low[src]=disc[src]=count;
        for(int nbr:adj[src])
        {
            if(parent[src]==nbr) continue;
            if(disc[nbr]==-1)
            {
                parent[nbr]=src;
                DFS(nbr,adj);
                if(low[nbr]>disc[src])
                {
                    List<Integer> ans=new ArrayList<>();
ans.add(src);ans.add(nbr);
                    obj.add(ans);
                }
                low[src]=Math.min(low[src],low[nbr]);
                }
        
        else
        {
           low[src]=Math.min(low[src],disc[nbr]);   
        }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        parent=new int[n];
        disc=new int[n];
        low=new int[n];
        obj=new ArrayList<>();
        Arrays.fill(disc,-1);
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(List<Integer> edge:connections)
        {
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        DFS(0,adj);
        return obj;
        
    }
}