class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int stops;
        int color;
        Pair (int node,int stops,int color)
        {
            this.node=node;
            this.stops=stops;
            this.color=color;
        }
           public int compareTo(Pair other){
            return this.stops - other.stops;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n=0;
      for(int []route:routes)
      {
          for(int nbr:route)
          {
              n=Math.max(n,nbr);
          }
      }
        ArrayList<Pair>[]adj=new ArrayList[n+1];
        for(int i=0;i<=n;i++)
            adj[i]=new ArrayList<>();
        for(int i=0;i<routes.length;i++)
        {
      for(int j=0;j<routes[i].length;j++)
      {
       int src=routes[i][j];
          int dest=routes[i][(j+1)%routes[i].length];
          adj[src].add(new Pair(dest,0,i));
            adj[dest].add(new Pair(src,0,i));
      }
            }
      PriorityQueue<Pair> pq=new PriorityQueue<>();
pq.add(new Pair(source,0,routes.length)) ;
    int [][]vis=new int[n+1][routes.length+1];
        for(int i=0;i<=n;i++)
        {
            Arrays.fill(vis[i],-1);
        }
        while(pq.size()>0)
        {
            Pair front =pq.remove();
            if(front.node==target)return front.stops;
            if(vis[front.node][front.color]!=-1)continue;
            vis[front.node][front.color]=front.stops;
            for(Pair nbr:adj[front.node])
            {
                if(front.color!=nbr.color)
               pq.add(new Pair(nbr.node,front.stops+1,nbr.color));
                else
                    pq.add(new Pair(nbr.node,front.stops,nbr.color));
            }
        }
        return -1;
    }
}