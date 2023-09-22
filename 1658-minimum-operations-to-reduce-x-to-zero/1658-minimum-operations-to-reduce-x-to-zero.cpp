class Solution {
public:
    int minOperations(vector<int>& arr, int x) {
 int total=0;
        for(int a:arr)
            total+=a;
        int subSum=total-x;
        if(subSum==0) return arr.size();
        int i=0;
        int sum=0;
        int len=0;
        for(int j=0;j<arr.size();j++)
        {
            sum+=arr[j];
            while(sum>0&&sum>subSum)
            {
                sum=sum-arr[i];
                i++;
            }
            if(sum==subSum)
                len=max(len,j-i+1);
        }
        if(len==0) return -1;
        return arr.size()-len;
    }
};