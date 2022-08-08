class Solution {
    List<String> path;
    public void DFS(String curr,HashMap<String,PriorityQueue<String>> adj)
    {
        while(adj.get(curr).size()>0)
        {
            String nbr=adj.get(curr).remove();
            DFS(nbr,adj);
        }
        path.add(curr);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String,PriorityQueue<String>> adj=new HashMap<>();
        for(int i=0;i<tickets.size();i++)
        {
            List<String> curr=tickets.get(i);
            if(adj.containsKey(curr.get(0))==false)
                adj.put(curr.get(0),new PriorityQueue<>());
                if(adj.containsKey(curr.get(1))==false)
                adj.put(curr.get(1),new PriorityQueue<>());
            adj.get(curr.get(0)).add(curr.get(1));
        }
      path=new ArrayList<>();
DFS("JFK",adj);
        Collections.reverse(path);
        return path;
    }
}