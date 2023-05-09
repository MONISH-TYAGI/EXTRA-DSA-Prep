class Solution {
    public boolean matchReplacement(String s, String sub, char[][] mappings) {
        HashMap<Character,HashSet<Character>> hm=new HashMap<>();
        for(int i=0;i<mappings.length;i++)
        {
            if(hm.containsKey(mappings[i][0])==false)
            {
                hm.put(mappings[i][0],new HashSet<>());
            }
            hm.get(mappings[i][0]).add(mappings[i][1]);
        }
        for(int i=0;i<=s.length()-sub.length();i++)
        {
            int j;
            for( j=0;j<sub.length();j++)
            {
    if(
        s.charAt(i+j)!=sub.charAt(j)&&
        hm.containsKey(sub.charAt(j))==true&&
        hm.get(sub.charAt(j)).contains(s.charAt(i+j))==true
        )
        continue;
                else if( s.charAt(i+j)!=sub.charAt(j))
                {
                    
                    break;
                }
            }
            if(j==sub.length())
                return true;
    
                
        }
        return false;
    }
}