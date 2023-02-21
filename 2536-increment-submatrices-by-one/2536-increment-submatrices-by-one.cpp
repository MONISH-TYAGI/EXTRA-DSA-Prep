class Solution {
public:
    vector<vector<int>> rangeAddQueries(int n, vector<vector<int>>& queries) {
        
        // vector<vector<int>>ans(n,vector<int>(n,0));
        vector<vector<int>>ans(n,vector<int>(n,0));
        // row size n column size n+1
        // vector<vector<int>>diff(n,vector<int>(n+1,0));
                vector<vector<int>>diff(n,vector<int>(n+1,0));
        // I will use the concept of difference array for row 

        // i will take the row wise prefix sum of the difference array and assign it back to our ans 2d array 

   for(int i=0;i<queries.size();i++)
   {
       int startRow=queries[i][0];
       int startCol=queries[i][1];
       int endRow=queries[i][2];
       int endCol=queries[i][3];
       for(int k=startRow;k<=endRow;k++)
       {
           diff[k][startCol]++;
           diff[k][endCol+1]--;
       }
   }
        
        // now take prefix sum of every row of difference matrix

  for(int i=0;i<n;i++)
  {
      for(int j=0;j<n;j++)
      {
          if(j!=0)
          diff[i][j]=diff[i][j]+diff[i][j-1];
           ans[i][j]=diff[i][j];
      }
     
  }

        return ans;
    }
};