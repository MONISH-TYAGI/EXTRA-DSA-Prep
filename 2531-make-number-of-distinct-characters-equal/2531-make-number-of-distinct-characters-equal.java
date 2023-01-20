class Solution {
    public boolean isItPossible(String word1, String word2) {
        HashMap<Character,Integer> hm1=new HashMap<>();
        HashMap<Character,Integer> hm2=new HashMap<>();
        HashSet<Character> hs1=new HashSet<>();
        HashSet<Character> hs2=new HashSet<>();
                if(word1.length()>word2.length())
        {
            String temp=word2;
            word2=word1;
            word1=temp;
        }
        for(Character ch:word1.toCharArray())
        {
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
            hs1.add(ch);
        }
        for(Character ch:word2.toCharArray())
        {
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
            hs2.add(ch);
        }
        // if(hm1.size()==hm2.size())
        //     return true;

        for(char ch1:hs1)
        {
            
            for(char ch2:hs2){
            
            if(hm1.get(ch1)==1)
                hm1.remove(ch1);
            else
                hm1.put(ch1,hm1.get(ch1)-1);
            if(hm2.get(ch2)==1)
                hm2.remove(ch2);
            else
                hm2.put(ch2,hm2.get(ch2)-1);
            hm1.put(ch2,hm1.getOrDefault(ch2,0)+1);
            hm2.put(ch1,hm2.getOrDefault(ch1,0)+1);
            // System.out.println(hm1);
            // System.out.println(hm2);
            if(hm1.size()==hm2.size()) return true;
            hm1.put(ch2,hm1.getOrDefault(ch2,0)-1);
            if(hm1.get(ch2)==0)
                hm1.remove(ch2);
            hm2.put(ch1,hm2.getOrDefault(ch1,0)-1);
             if(hm2.get(ch1)==0)
                hm2.remove(ch1);
            hm1.put(ch1,hm1.getOrDefault(ch1,0)+1);
            hm2.put(ch2,hm2.getOrDefault(ch2,0)+1);
            // System.out.println(hm1);
            // System.out.println(hm2);
            }
        }
        return false;
    }
}