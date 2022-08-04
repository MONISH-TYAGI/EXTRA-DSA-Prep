class Solution {
     public   class Pair implements Comparable<Pair>{
        int node;
        int dist;
        Pair (int node,int dist)
        {
            this.node=node;
            this.dist=dist;
        }
        public int compareTo(Pair other)
        {
           return  (this.dist-other.dist);
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int count=0;
                PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int cost=0;
        int []vis=new int[n];
        Arrays.fill(vis,-1);
        while(pq.size()>0)
        {
            Pair front=pq.remove();
            if(vis[front.node]!=-1) continue;
            vis[front.node]=front.dist;
            count++;
            cost=cost+front.dist;
            if(count==n) return cost;
            for(int i=0;i<n;i++)
            {
                if(front.node==i) continue;
                int dist=Math.abs(points[front.node][0]-points[i][0])+Math.abs(points[front.node][1]-points[i][1]);
                pq.add(new Pair(i,dist));
            }
        }
        return cost;
    }
}