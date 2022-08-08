class Solution {
class DSU {
    int[] parent;

    DSU(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a <= b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public int find(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        DSU sets=new DSU(s.length()+1);
     HashMap<Integer,ArrayList<Integer>> index=new HashMap<>();
             HashMap<Integer,ArrayList<Character>> parent=new HashMap<>();
for(List<Integer> pair:pairs)
{
    sets.union(pair.get(0),pair.get(1));
}
for(int i=0;i<s.length();i++)
{
    int origin=sets.find(i);
   if(index.containsKey(origin)==false){
    index.put(origin,new ArrayList<>());
    parent.put(origin,new ArrayList<>());
    }
        index.get(origin).add(i);
    parent.get(origin).add(s.charAt(i));
}
        StringBuilder res=new StringBuilder(s);
        for(Integer idx:index.keySet())
        {
             Collections.sort(parent.get(idx));
            // System.out.println(parent.get(idx));
                        System.out.println(index.get(idx));
            for(int j=0;j<parent.get(idx).size();j++)
            {
                int k=index.get(idx).get(j);
                char ch=parent.get(idx).get(j);
                res.setCharAt(k,ch);
            }
            
        }
        return res.toString();
    }
}