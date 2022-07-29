class Solution {
    public void paint(int [][]image,int row,int col,int color,int prevColor)
    {
        if(row<0||col<0||row>=image.length||col>=image[0].length) return ;
        if(image[row][col]!=prevColor) return ;
     image[row][col]=color;
        paint(image,row+1,col,color,prevColor);
        paint(image,row,col+1,color,prevColor);
        paint(image,row-1,col,color,prevColor);
        paint(image,row,col-1,color,prevColor);
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      if(image[sr][sc]==color)
          return image;
        paint(image,sr,sc,color,image[sr][sc]);
        return image;
    }
}