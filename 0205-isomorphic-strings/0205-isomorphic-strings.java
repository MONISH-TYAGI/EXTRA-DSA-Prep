class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> hm=new HashMap<>();
        HashSet<Character> hm2=new HashSet<>();
        for(int i=0;i<s.length();i++)
        {
     char ch=s.charAt(i);
            if(hm.containsKey(ch)==true)
            {
                if(hm.get(ch)!=t.charAt(i))
                    return false;
            }else {
                if(hm2.contains(t.charAt(i))==true) return false;
            hm2.add(t.charAt(i));
            hm.put(ch,t.charAt(i));
            }
                
        }
        return true;
    }
}