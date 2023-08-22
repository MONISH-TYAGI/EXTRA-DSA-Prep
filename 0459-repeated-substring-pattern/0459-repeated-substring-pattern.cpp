class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        int n=s.length();
        for(int i=1;i<=n/2;i++)
        {
            if(n%i==0)
            {
                string res=s.substr(0,i);
                // cout<<res<<endl;
                for(int j=1;j<n/i;j++)
                    res+=s.substr(0,i);
                if(res==s) return true;
            }
        }
        return false;
    }
};