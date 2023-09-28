class Solution {
public:
    string decodeAtIndex(string s, int k) {
    long size=0;
    for(int i=0;i<s.length();i++)
    {
        char ch=s[i];
        if(isdigit(ch)==false)
            size++;
        else
        {
            int dig=(int)(ch-'0');
            size=size*1ll*dig;
        }
    }
    for(int i=s.length()-1;i>=0;i--)
    {
        char ch=s[i];
        k=k%size;
        if(k==0&&isdigit(ch)==false)
        {
            string res="";
            res+=ch;
            return res;
        }
        if(isdigit(ch))
            size=size/(ch-'0');
        else
            size--;
    }
        return "";
    
    }
};