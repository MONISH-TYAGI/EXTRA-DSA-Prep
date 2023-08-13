class Solution {
public:
    int dx[4]={1,-1,0,0};
    int dy[4]={0,0,1,-1};
     bool isExist(int r,int c,int n,vector<vector<int>>&grid,int val,vector<vector<bool>>&box)
    {
        if(r==n-1&&c==n-1)return grid[r][c] >= val;
         box[r][c]=true;
        for(int i=0;i<4;i++)
        {
            int nr=r+dx[i];
            int nc=c+dy[i];
        if(nr>=0&&nr<n&&nc>=0&&nc<n&&grid[nr][nc]>=val&&box[nr][nc]==false)
        {
            bool ans=isExist(nr,nc,n,grid,val,box);
            if(ans==true) return true;
        }
            
        }
         // box[r][c]=false;
        return false;
    }
    int maximumSafenessFactor(vector<vector<int>>& grid) {
        int r=grid.size();
        int c=grid[0].size();
        int n=grid.size();
        queue<pair<int,int>> q;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]==1)
                    q.push({i,j});
            }
        }
        if(grid[0][0]==1||grid[n-1][n-1]==1) return 0; 
        while(q.size()>0)
        {
            int f=q.front().first;
            int s=q.front().second;
            int val=grid[f][s];
            q.pop();
            for(int x=0;x<4;x++)
            {
                int i=f+dx[x];
                int j=s+dy[x];
                if(i>=0&&j>=0&&i<r&&j<c&&grid[i][j]==0)
                {
                    grid[i][j]=val+1;
                    q.push({i,j});
                }
                
          else     if(i >= 0 && j >= 0 && i < r && j < c){
                                    grid[i][j] = min(grid[i][j],val+1);
                            }
            }
        }
        // for(int i=0;i<n;i++)
        // {
        //     for(int j=0;j<n;j++)
        //         cout<<grid[i][j]<<" ";
        //     cout<<endl;
        // }
        // cout<<endl;
        int ans=0;
        int left=0,right=401;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            vector<vector<bool>> box(n,vector<bool>(n,false));
            if(isExist(0,0,n,grid,mid,box)&&grid[0][0]>=mid)
            {
                 // cout<<left<<" "<<right<<" "<<mid<<endl;
                ans=max(ans,mid);
                left=mid+1;
                
               
            }else
                right=mid-1;
            
        }
        return ans-1;
    }
};