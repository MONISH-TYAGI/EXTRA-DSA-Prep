class Solution {
    public int minFlips(int a, int b, int c) {
        int ans=0;
        for(int i=0;i<32;i++)
        {
            int athbit=((a&(1<<i))==0)?0:1;
            int bthbit=((b&(1<<i))==0)?0:1;
            int cthbit=((c&(1<<i))==0)?0:1;
    if(athbit==0&&bthbit==0&&cthbit==1)
        ans++;
    else if(athbit==0&&bthbit==1&&cthbit==0)
        ans++;
           else if(athbit==1&&bthbit==0&&cthbit==0)
        ans++;
            else if(athbit==1&&bthbit==1&&cthbit==0)
                ans=ans+2;
        }
        return ans;
    }
}