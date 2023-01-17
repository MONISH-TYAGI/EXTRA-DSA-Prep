class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        int ans=0;
        boolean flag=false;
        for(char ch:hm.keySet())
        {
            int val=hm.get(ch);
            if(val%2==1)flag=true;
            val=val/2;
            ans+=2*val;
        }
        if(flag==true) ans++;
        return ans;
    }
}