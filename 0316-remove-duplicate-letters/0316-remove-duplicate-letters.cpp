class Solution {
public:
    string removeDuplicateLetters(string str) {
        unordered_map<char,int> mp;
        unordered_set<char> s;
        stack<char> stk;
        for(int i=0;i<str.length();i++)
        {
            mp[str[i]]++;
        }
        for(int i=0;i<str.length();i++)
        {
            char ch=str[i];
            if(s.find(ch)!=s.end()){
                mp[ch]--;
                continue;
                                   }
            if(stk.size()==0)
            {
                stk.push(ch);
                s.insert(ch);
                mp[ch]--;
            }else
            {
                while(stk.size()>0&&stk.top()>str[i]&&mp[stk.top()]>0)
                {
                    
                    s.erase(stk.top());
                    stk.pop();
                    
                }
                stk.push(str[i]);
                s.insert(str[i]);
                mp[str[i]]--;
            }
        }
        string ans;
        while(stk.size()>0)
        {
            ans+=stk.top();
            stk.pop();
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};