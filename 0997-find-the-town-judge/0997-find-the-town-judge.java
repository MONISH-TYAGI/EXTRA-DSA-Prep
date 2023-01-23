class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean [][]mat=new boolean[n+1][n+1];
        for(int i=0;i<trust.length;i++)
        {
            int []curr=trust[i];
            mat[curr[0]][curr[1]]=true;
        }
        for(int j=1;j<=n;j++)
        {
            int count=0;
            for(int i=1;i<=n;i++)
            {
                if(i!=j&&mat[i][j]==true)
                    count++;
                if(count==n-1)
                {
                    boolean flag=false;
                    for(int k=1;k<=n;k++)
                    {
                        if(mat[j][k]==true)
                        {
                            flag=true;
                        }
                    }
                    if(flag==false)
                        return j;
                }
            }
        }
        return -1;
    }
}