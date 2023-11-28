#define MOD 1000000007
class Solution {
public:
    int arr[4][3][5001];
    int calculate(vector<vector<int>> &mat,int i,int j,int n,int m,int N)
    {
        // cout<<i<<"-"<<j<<endl;
        
        if(i<0||j<0||i>=n||j>=m) return 0;
if(mat[i][j]==1) return 0;
        if(N==1) {
            // cout<<i<<j<<endl;
            return 1;
        }
        if(arr[i][j][N]!=-1) return arr[i][j][N];
        // mat[i][j]=1;
      int upleft=calculate(mat,i-2,j-1,n,m,N-1);
      int upright=calculate(mat,i-2,j+1,n,m,N-1);
    int leftup=calculate(mat,i-1,j-2,n,m,N-1);
    int leftdown=calculate(mat,i+1,j-2,n,m,N-1);
   int downleft=calculate(mat,i+2,j-1,n,m,N-1);
    int downright=calculate(mat,i+2,j+1,n,m,N-1);
    int rightup=calculate(mat,i-1,j+2,n,m,N-1);
 int rightdown=calculate(mat,i+1,j+2,n,m,N-1);
        // mat[i][j]=0;
    int val=0;
        val=(val%MOD+upleft%MOD)%MOD;
      val=(val%MOD+upright%MOD)%MOD;
         val=(val%MOD+leftup%MOD)%MOD;
         val=(val%MOD+leftdown%MOD)%MOD;
         val=(val%MOD+downleft%MOD)%MOD; 
        val=(val%MOD+downright%MOD)%MOD;
         val=(val%MOD+rightup%MOD)%MOD;
        val=(val%MOD+rightdown%MOD)%MOD;
        return arr[i][j][N]=val;
    }
    int knightDialer(int n) {
        for(int i=0;i<4;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<5001;k++)
                    arr[i][j][k]=-1;
            }
        }
        vector<vector<int>> mat(4,vector<int>(3,0));
       
        mat[3][0]=mat[3][2]=1;
        int ans=0;
        for(int i=0;i<mat.size();i++)
        {
            for(int j=0;j<mat[i].size();j++)
            {
         if(mat[i][j]==0)
                ans=(ans%MOD+calculate(mat,i,j,4,3,n)%MOD)%MOD;
                
            }
        }
        return ans;
    }
};