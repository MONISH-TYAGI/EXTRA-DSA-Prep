class Solution {
public:
    vector<int> countBits(int n) {
        vector<int>  arr(n+1);
        for(int i=0;i<=n;i++)
        {
          int num=i;
            int cnt=0;
            // cout<<"---"<<endl;
            // cout<<num<<endl;
          while(num>0)
          {
              // cout<<(num&1)<<endl;
              if(num&1!=0)
                  cnt++;
              num=num>>1;
              // cout<<num<<endl;
              
          }
            arr[i]=cnt;
        }
        return arr;
    }
};