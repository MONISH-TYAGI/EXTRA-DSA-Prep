class Solution {
    public int max=0;
    public void findAns(int currSum,HashMap<Character,Integer> hm,int currIdx,String[]words,int []score)
    {
        if(currIdx==words.length)
        {
            if(currSum>max)
                max=currSum;
            return;
        }
        HashMap<Character,Integer> obj=new HashMap<>();
        for(char ch:hm.keySet())
            obj.put(ch,hm.get(ch));
            
        findAns(currSum,hm,currIdx+1,words,score);
        int out=0;
        String currWord=words[currIdx];
        int sum=0;
        int count=0;
        for(int i=0;i<currWord.length();i++)
        {
            char ch=currWord.charAt(i);
            if(obj.containsKey(ch)==true)
            {
             int freq=obj.get(ch);
             if(freq>0)
             {
           int val=score[ch-'a'];
                 sum+=val;
                 obj.put(ch,freq-1);
                 count++;
             }
                else
                {
                    out=1;
                    // hm.put(ch,hm.get(ch)+count);
                    break;
                }
            }
            else
            {
               out=1;
                break;
            }
            
            
        }
        if(out!=1)
        {
            currSum+=sum;
            findAns(currSum,obj,currIdx+1,words,score);
        }
    
    }
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:letters)
        {
            if(hm.containsKey(ch)==false)
            {
                hm.put(ch,1);
            }else
                hm.put(ch,hm.get(ch)+1);
        }
        findAns(0,hm,0,words,score);
        return max;
    }
}