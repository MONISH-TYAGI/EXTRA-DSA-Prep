class Solution {
public:
    int countStudents(vector<int>& students, vector<int>& sandwiches) {
        int n=students.size();
        vector<int> vis(n);
        int j=0;
        int k=0;
        for(int i=0;i<n;i++)
        {
            while(1)
            {
                if(students[j%n]==sandwiches[i]&&vis[j%n]==0)
                {
                    vis[j%n]=1;
                    break;
                }else
                    j++;
                k++;
                if(k>10000)
                    return n-i;
            }
        }
        return 0;
    }
};