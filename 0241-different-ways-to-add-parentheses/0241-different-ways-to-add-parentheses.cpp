class Solution {
public:
    vector<int> helper(string curr)
    {
        if(curr.length()<=2) 
        {
            vector<int> v;
            v.push_back(stoi(curr));
            return v;
        }
        vector<int>ans;
        for(int i=0;i<curr.length();i++)
        {
            char ch=curr[i];
            if(ch=='+'||ch=='-'||ch=='*')
            {
                string lefts=curr.substr(0,i);
                string rights=curr.substr(i+1,curr.length());
                vector<int> left=helper(lefts);
                vector<int> right=helper(rights);
                for(int i=0;i<left.size();i++)
                {
                    for(int j=0;j<right.size();j++)
                    {
             int first=left[i];
                        int second=right[j];
                        if(ch=='+')
                            ans.push_back(first+second);
                        else if(ch=='-')
                            ans.push_back(first-second);
                        else
                            ans.push_back(first*second);
                    }
                }
            }
        }
        return ans;
    }
    vector<int> diffWaysToCompute(string expression) {
       return helper(expression);
    }
};