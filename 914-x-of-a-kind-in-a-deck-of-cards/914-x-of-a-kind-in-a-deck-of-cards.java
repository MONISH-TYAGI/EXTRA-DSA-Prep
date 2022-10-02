class Solution {
        public int GCD(int min,int max)
    {
        if(min==0)return max;
        return GCD(max%min,min);
    }
    public boolean hasGroupsSizeX(int[] deck) {
    HashMap<Integer,Integer>hm=new HashMap<>();
        for(int a:deck)
        {
            hm.put(a,hm.getOrDefault(a,0)+1);
        }
        int gcd=0;
       for(int a:hm.keySet())
       {
            gcd=GCD(gcd,hm.get(a));
       }
        if(gcd<2)
            return false;
        else
            return true;
    }
}