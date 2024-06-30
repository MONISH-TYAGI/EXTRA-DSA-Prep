#define ll long long int 
class TrieNode
{
    public : 
    unordered_map<string,TrieNode*> children;
    int cnt;
    TrieNode()
    {
        cnt=0;
    }
};
class Solution {
public:
    TrieNode *root;
    Solution()
    {
        root=new TrieNode();
    }
    long long countPrefixSuffixPairs(vector<string>& words) {
        ll ans=0;
        for(auto word:words)
        {
            TrieNode *curr=root;
            int n=word.size();
            for(int i=0;i<word.size();i++)
            {
                string node = string(1, word[i]) + string(1, word[n-1-i]);
              //  cout<<node<<endl;
                if(curr->children.find(node)==curr->children.end())
                    curr->children[node]=new TrieNode();
                curr=curr->children[node];
                ans+=curr->cnt;
            }
            curr->cnt++;
        }
        return ans;
    }
};