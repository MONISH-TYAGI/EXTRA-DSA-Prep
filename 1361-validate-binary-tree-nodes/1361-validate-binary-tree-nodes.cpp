class Solution {
public:
    int func(int n, vector<int>& leftChild, vector<int>& rightChild)
    {
        bool check[n];
        fill(check,check+n,false);
        for(int a:leftChild)
        {
            if(a!=-1)
                check[a]=true;
        }
        for(int a:rightChild)
        {
            if(a!=-1)
                check[a]=true;
        }
        for(int i=0;i<n;i++)
        {
            if(check[i]==false)
                return i;
        }
        return -1;
    }
    bool validateBinaryTreeNodes(int n, vector<int>& leftChild, vector<int>& rightChild) {
        bool check[n+1];
        fill(check,check+n+1,false);
        queue<int> q;
        int findRoot=func(n,leftChild,rightChild);
        if(findRoot==-1) return false;
        q.push(findRoot);
        
        while(q.size()>0)
        {
            int top=q.front();
            q.pop();
            if(check[top]==false)
            check[top]=true;
            else
                return false;
            if(leftChild[top]!=-1)
                q.push(leftChild[top]);
            if(rightChild[top]!=-1)
                q.push(rightChild[top]);
            
            
        }
        for(int i=0;i<n;i++)
        {
            if(check[i]==false) return false;
        }
        return true;
    }
};