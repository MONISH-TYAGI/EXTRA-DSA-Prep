class Solution {
public int getCost(int x1,int x2,int y1,int y2)
{
    return Math.abs(x1-x2)+Math.abs(y1-y2);
}
    class Pair implements Comparable<Pair> {
        int node;
        int dist;
        Pair(int t,int s)
        {
            node=t;
            dist=s;
        }
        public int compareTo(Pair other)
        {
            return this.dist-other.dist;
        }
    }
    record Point(int x, int y) {}
    public int minimumCost(int[] start, int[] target, int[][] specialRoads) {
        for(int []arr:specialRoads)
        {
            int dist=arr[4];
            int val=getCost(arr[0],arr[2],arr[1],arr[3]);
            if(val<dist)
                arr[4]=val;
        }
   HashMap<Point,Integer> hm=new HashMap<>();
       
        hm.put(new Point(start[0],start[1]),1);
                hm.put(new Point(target[0],target[1]),2);
        int idx=3;
        for(int []arr:specialRoads)
        {
            Point m=new Point(arr[0],arr[1]);
                if(hm.containsKey(m)==false)
            hm.put(m,idx++);
            Point n=new Point(arr[2],arr[3]);
                if(hm.containsKey(n)==false)
        hm.put(n,idx++);

        }
        ArrayList<Pair> []adj=new ArrayList[idx+1];
        for(int i=0;i<adj.length;i++)
            adj[i]=new ArrayList<>();
 
        Point curr1=new Point(start[0],start[1]);
            Point curr2=new Point(target[0],target[1]);
            int first=hm.get(curr1);
            int second=hm.get(curr2);
            adj[first].add(new Pair(second,getCost(start[0],target[0],start[1],target[1])));
               for(int []arr:specialRoads)
        {
             curr1=new Point(arr[0],arr[1]);
             curr2=new Point(arr[2],arr[3]);
             first=hm.get(curr1);
             second=hm.get(curr2);
            int cost=arr[4];
            int costO=getCost(start[0],arr[0],start[1],arr[1]);
        int costE=getCost(arr[2],target[0],arr[3],target[1]);
                  adj[1].add(new Pair(first,costO));
                 adj[first].add(new Pair(second,cost));
                   adj[second].add(new Pair(2,costE));
         for(int []narr:specialRoads)
         {
             if(arr==narr)
                 continue;
             int spOO=hm.get(new Point(narr[0],narr[1]));
             int spEE=hm.get(new Point(narr[2],narr[3]));
             int cost1=getCost(arr[2],narr[0],arr[3],narr[1]);
             int cost2=getCost(narr[2],arr[0],narr[3],arr[1]);
             adj[second].add(new Pair(spOO,cost1));
             adj[spEE].add(new Pair(first,cost2));
         }
                   
        }
        
        PriorityQueue<Pair> q=new PriorityQueue<>();
        q.add(new Pair(1,0));
        int []vis=new int[idx+1];
        Arrays.fill(vis,Integer.MAX_VALUE);
        while(q.size()>0)
        {
            Pair top=q.remove();
            if(vis[top.node]!=Integer.MAX_VALUE)continue;
            vis[top.node]=top.dist;
            for(Pair nbr:adj[top.node])
                q.add(new Pair(nbr.node,top.dist+nbr.dist));
        }

        return vis[2];
    }
}