class Solution {
    public void printAllPaths(int src,int dest,List<Integer>path,List<List<Integer>> Path,boolean []vis,int[][] graph)
    {
        if(vis[src]==true)
            return ;
        if(src==dest)
        {
            path.add(dest);
            Path.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return ;
        }
        vis[src]=true;
        path.add(src);
        for(int nbr:graph[src])
        {
            printAllPaths(nbr,dest,path,Path,vis,graph);
        }
        vis[src]=false;
        path.remove(path.size()-1);
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path=new ArrayList<>();
        List<List<Integer>> Path=new ArrayList<>();
        boolean []vis=new boolean[graph.length];
         printAllPaths(0,graph.length-1,path,Path,vis,graph);
        return Path;
    }
}