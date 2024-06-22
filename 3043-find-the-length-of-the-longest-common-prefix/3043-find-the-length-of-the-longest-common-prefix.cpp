class Solution {
public:
    int longestCommonPrefix(vector<int>& arr1, vector<int>& arr2) {
      unordered_set<string> container;
        for(int i=0;i<arr1.size();i++)
        {
            string num=to_string(arr1[i]);
            for(int j=0;j<num.size();j++)
            {
                string curr=num.substr(0,j+1);
                container.insert(curr);
            }
        }
        cout<<container.size()<<endl;
        int maxm=0;
        for(int i=0;i<arr2.size();i++)
        {
            string num=to_string(arr2[i]);
            for(int j=0;j<num.size();j++)
            {
                string curr=num.substr(0,j+1);
                if(container.find(curr)!=container.end())
                    maxm=max(static_cast<int>(curr.size()),maxm);
            }
        }
        return maxm;
        
    }
};