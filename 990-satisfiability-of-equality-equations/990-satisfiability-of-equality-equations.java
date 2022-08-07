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
    public boolean equationsPossible(String[] equations) {
        DSU sets=new DSU(27);
        for(int i=0;i<equations.length;i++)
        {
            char ch=equations[i].charAt(1);
            if(ch=='=')
            {
                int first=equations[i].charAt(0)-'a';
                int second=equations[i].charAt(3)-'a';
                sets.union(first,second);
            }
        }
           for(int i=0;i<equations.length;i++)
        {
            char ch=equations[i].charAt(1);
            if(ch=='!')
            {
                int first=equations[i].charAt(0)-'a';
                int second=equations[i].charAt(3)-'a';
                if(sets.find(first)==sets.find(second)) return false;
            }
        }
        return true;
    }
}