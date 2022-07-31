class Solution {
    public boolean DFS(int curr,int level,int []visited,int [][]graph)
    {
        if(visited[curr]!=-1)
        {
            if(visited[curr]==level%2) return true;
            return false;
        }
        visited[curr]=level%2;
        for(int nbr=0;nbr<graph[curr].length;nbr++)
        {
            if(DFS(graph[curr][nbr],level+1,visited,graph)==false)
                return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int []visited=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int i=0;i<graph.length;i++)
        {
            if(visited[i]==-1&&DFS(i,0,visited,graph)==false)
                return false;
        }
        return true;
    }
}