class Solution {
    public int takeCharacters(String s, int k) {
        if(k==0) return 0;
        int aCount=0,bCount=0,cCount=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='a') aCount++;
            else if(ch=='b') bCount++;
            else
                cCount++;
        }
        aCount-=k;
        bCount-=k;
        cCount-=k;
        if(aCount<0||bCount<0||cCount<0) return -1;
        int max=0;
        int j=0;
        int a=0,b=0,c=0;
        int i;
        for( i=0;i<s.length();i++)
        {
            // char ch=s.charAt(i);
            char ch=s.charAt(i);
            if(ch=='a') a++;
            else if(ch=='b') b++;
            else
                c++;
            if(a>aCount||b>bCount||c>cCount)
            {
                              max=Math.max(max,i-j); 
                // System.out.println("max-> "+max);
                while(a>aCount||b>bCount||c>cCount)
                {
                    char ch1=s.charAt(j);
                    if(ch1=='a')
                        a--;
                    else if(ch1=='b')
                        b--;
                    else
                        c--;
                    j++;
                    // System.out.println(j);
                }

            }
             
        }
        max=Math.max(max,i-j); 
        // System.out.println("max-> "+max);
        return s.length()-max;
    }
}