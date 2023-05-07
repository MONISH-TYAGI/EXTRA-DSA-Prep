class Solution {
    char findFirstValidCharacter(char[]s,int i,char limit,char c)
    {
        for(;c<=limit&&(i>=1)&&c==s[i-1]||(i>=2&&c==s[i-2]);++c);
        return c;
    }
    public String smallestBeautifulString(String s, int k) {
        char []str=s.toCharArray();
        char limit=(char)('a'+k-1);
        int n=s.length();
        for(int i=n-1;i>=0;--i)
        {
            char c=findFirstValidCharacter(str,i,limit,(char)(s.charAt(i)+1));
            if(c<=limit)
            {
                str[i]=c;
                for(++i;i<n;++i)
                {
                    str[i]=findFirstValidCharacter(str,i,limit,'a');
                    
                }
                return String.valueOf(str);
            }
        }
        return "";
    
}
}