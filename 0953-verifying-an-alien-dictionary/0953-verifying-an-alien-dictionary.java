class Solution {
    public boolean isAlienSorted(String[] words, String order) {
      HashMap<Character,Integer> hm=new HashMap<>();
        int count=0;
        for(int i=0;i<order.length();i++)
        {
            char ch=order.charAt(i);
            hm.put(ch,count);
            count++;
        }
        for(int i=0;i<=words.length-2;i++)
        {
            boolean check=true;
        String first=words[i];
            String second=words[i+1];
            int min=Math.min(first.length(),second.length());
            int con=-1;
            for(int j=0;j<min;j++)
            {
                if(first.charAt(j)==second.charAt(j)) continue;
                else
                {
                    int firstVal=hm.get(first.charAt(j));
                    int secondVal=hm.get(second.charAt(j));
                    if(firstVal<secondVal)
                    {
                        con=0;
                        break;
                    }
                    else
                        return false;
                }
            }
            if(first.length()>second.length()&&con==-1)
                return false;
            
        }
        return true;
    }
}