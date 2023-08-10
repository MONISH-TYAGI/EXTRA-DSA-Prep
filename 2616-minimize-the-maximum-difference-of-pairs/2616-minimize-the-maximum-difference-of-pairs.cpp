class Solution {
public:
    int minimizeMax(vector<int>& A, int p) {
      sort(A.begin(),A.end());
        int n=A.size();
        int left=0;
        int right=A[n-1]-A[0];
        while(left<right)
        {
            int mid=left+(right-left)/2;
            int k=0;
            for(int i=1;i<n;i++)
            {
                if(A[i]-A[i-1]<=mid)
                {
                    k++;
                    i++;
                }
                if(k==p)break;
            }
            if(k>=p)
                right=mid;
            else
                left=mid+1;
        }
        return right;
    }
};