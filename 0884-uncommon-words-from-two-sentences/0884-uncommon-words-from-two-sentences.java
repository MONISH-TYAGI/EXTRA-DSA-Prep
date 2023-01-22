class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String curr:s1.split(" "))
        {
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }
         for(String curr:s2.split(" "))
        {
            hm.put(curr,hm.getOrDefault(curr,0)+1);
        }
        List<String> obj=new ArrayList<>();
        for(String curr:hm.keySet())
        {
            if(hm.get(curr)==1)
                obj.add(curr);
        }
        String []arr=new String[obj.size()];
        int i=0;
        for(String curr:obj)
            arr[i++]=curr;
        return arr;
    }
}