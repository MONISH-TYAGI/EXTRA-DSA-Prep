class Solution {
     class DSU {
        int[] parent;
        int[] rank;

        DSU(int n) {
            parent = new int[n];
            Arrays.fill(parent, -1);
            rank = new int[n];
            Arrays.fill(rank, 1);
        }

        public void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb)
                return;

            if (rank[pa] > rank[pb]) {
                parent[pb] = pa;
                rank[pa] += rank[pb];
            } else {
                parent[pa] = pb;
                rank[pb] += rank[pa];
            }
        }

        public int find(int a) {
            if (parent[a] == -1)
                return a;
            return parent[a] = find(parent[a]);
        }
    }
    class Edge implements Comparable <Edge>{
        int src;
        int dest;
        int dist;
        int idx;
        Edge(int src,int dest,int dist,int idx)
        {
            this.src=src;
            this.dest=dest;
            this.dist=dist;
            this.idx=idx;
        }
        public int compareTo(Edge other)
        {
            return this.dist-other.dist;
        }
    }
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DSU sets=new DSU(n+1);
        ArrayList<Edge> obj=new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            obj.add(new Edge(queries[i][0],queries[i][1],queries[i][2],i));
        }
        Collections.sort(obj);
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        boolean []ans=new boolean[queries.length];
        int idx=0;
        for(int i=0;i<obj.size();i++)
        {
            int currDist=obj.get(i).dist;
            while(idx<edgeList.length&&currDist>edgeList[idx][2])
            {
                sets.union(edgeList[idx][0],edgeList[idx][1]);
                idx++;
            }
            if(sets.find(obj.get(i).src)==sets.find(obj.get(i).dest))
                ans[obj.get(i).idx]=true;
            
        }
        return ans;
    }
}