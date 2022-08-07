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
    public int[] findRedundantConnection(int[][] edges) {
        DSU sets=new DSU(10005);
        int []ans=new int[2];
        for(int i=0;i<edges.length;i++)
        {
         if(sets.find(edges[i][0])==sets.find(edges[i][1]))
         {
             ans[0]=edges[i][0];
             ans[1]=edges[i][1];
             continue;
         }
            sets.union(edges[i][0],edges[i][1]);
        }
        return ans;
    }
}