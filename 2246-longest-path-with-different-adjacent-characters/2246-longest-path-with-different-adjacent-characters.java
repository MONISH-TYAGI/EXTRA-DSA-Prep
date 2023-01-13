class Solution {
    public class Graph {
        ArrayList<Integer>[]adj;
        Graph(int n)
        {
            adj=new ArrayList[n];
            for(int i=0;i<n;i++)
                adj[i]=new ArrayList<>();
        }
        public void addEdge(int src,int dest,boolean isDirected)
        {
            adj[src].add(dest);
            if(isDirected==false)
                adj[dest].add(src);
        }
    }
    int longestPathLen=0;
    public int dfs(int src,Graph g,String s)
    {
        int maxLen=0,secondMaxLen=0;
        for(int nbr:g.adj[src])
        {
            int currLen=dfs(nbr,g,s);
            if(s.charAt(src)!=s.charAt(nbr))
            {
                if(currLen>maxLen)
                {
                    secondMaxLen=maxLen;
                    maxLen=currLen;
                }else if(currLen>secondMaxLen)
                    secondMaxLen=currLen;
            }
        }
        longestPathLen=Math.max(longestPathLen,maxLen+secondMaxLen+1);
        return maxLen+1;
    }
    public int longestPath(int[] parent, String s) {
        Graph g=new Graph(parent.length);
        for(int i=1;i<parent.length;i++)
        {
            g.addEdge(parent[i],i,true);
        }
        dfs(0,g,s);
        return longestPathLen;
    }
}