#define ll long long int 
class TrieNode
{
    public : 
    unordered_map<int,TrieNode*> children;
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
                int node=word[i]*128+word[n-1-i];
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