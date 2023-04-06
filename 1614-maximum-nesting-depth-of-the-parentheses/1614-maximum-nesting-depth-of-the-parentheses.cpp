class Solution {
public:
    int maxDepth(string s) {
        int depth=0;
        int maxm=0;
        for(int i=0;i<s.length();i++)
        {
            if(s[i]=='(')
                depth++;
            else if(s[i]==')')
                depth--;
            maxm=max(maxm,depth);
        }
        return maxm;
    }
};