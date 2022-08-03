class Solution {
    class Pair implements Comparable<Pair>
    {
        int node;
        double prob;
        Pair(int node,double prob)
        {
            this.node=node;
            this.prob=prob;
        }
        public int compareTo(Pair other)
        {
            if(this.prob-other.prob<0) return 1;
            if(this.prob-other.prob>0) return -1;
            return 0;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        ArrayList<Pair> []adj=new ArrayList[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
       for(int i=0;i<edges.length;i++)
    {
        adj[edges[i][0]].add(new Pair(edges[i][1],succProb[i]));
    adj[edges[i][1]].add(new Pair(edges[i][0],succProb[i]));
    }
        PriorityQueue<Pair> pq=new PriorityQueue<>();
                        double[]visited=new double[n];
                        Arrays.fill(visited,-1);
    pq.add(new Pair(start,1.0));       
          while(pq.size()>0)
 {
     Pair front=pq.remove();
              // System.out.println(front.prob);
     if(visited[front.node]!=-1) continue;
     visited[front.node]=front.prob;
     for(Pair nbr:adj[front.node])
     {
        pq.add(new Pair(nbr.node,front.prob*nbr.prob));
     }
                            
   }
if(visited[end]!=-1)
        return visited[end];
    return 0;
                        }
}