class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
      int []prefixArr=new int[arr.length];
        prefixArr[0]=arr[0];
        for(int i=1;i<prefixArr.length;i++)
        {
            prefixArr[i]=prefixArr[i-1]^arr[i];
            
        }
        int []res=new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
int left=queries[i][0];
            int right=queries[i][1];
            if(left==0)
            {
                res[i]=prefixArr[right];
            }else
            {
                res[i]=prefixArr[left-1]^prefixArr[right];
            }
                
                
        }
        return res;
    }
}