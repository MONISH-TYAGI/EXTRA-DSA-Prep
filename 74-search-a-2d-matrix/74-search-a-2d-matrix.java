class Solution {
      public static int find(int[][]matrix,int target)
    {
                int left=0;
        int right=matrix.length-1;
        int lastIdx=matrix[0].length-1;
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(matrix[mid][0]<=target&&target<=matrix[mid][lastIdx]) return mid;
            if(matrix[mid][0]<target)
            left=mid+1;
            else
            right=mid-1;
        }
       return -1; 
    }
    public boolean searchMatrix(int[][] matrix, int target) {
                int Row=find(matrix,target);
        // System.out.println(Row);
if(Row==-1) return false;
        if(Row<matrix.length&&matrix[Row][0]<=target&&matrix[Row][matrix[0].length-1]>=target){
            // System.out.println("hello");
        int left=0;
        int right=matrix[0].length-1;
        while(left<=right)
        {
            int mid=left+((right-left)/2);
            // System.out.println("left "+left+" right "+right+" mid "+mid+" val "+matrix[Row][mid]);
            if(matrix[Row][mid]==target) return true;
            else if(matrix[Row][mid]<target) left=mid+1;
            else right=mid-1;
        }
        }
        return false;
    }
}