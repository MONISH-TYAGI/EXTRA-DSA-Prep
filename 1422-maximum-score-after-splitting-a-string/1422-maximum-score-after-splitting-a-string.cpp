class Solution {
public:
    int maxScore(string s) {
    int ans=INT_MIN;
        int f=0,sc=0;
        bool one=false;
        bool zero=false;
        for(char ch:s)
        {
            if(ch=='1')
                one=true;
            else
                zero=true;
        }
        if(one==false||zero==false) return s.length()-1;
        for(int i=0;i<s.length()-1;i++)
        {
       if(s[i]=='0')
           f++;
            sc=0;
        for(int j=i+1;j<s.length();j++)
        {
            if(s[j]=='1')
                sc++;
        }
        int curr=f+sc;
            ans=max(ans,curr);
        }
        
        return ans;
    }
};