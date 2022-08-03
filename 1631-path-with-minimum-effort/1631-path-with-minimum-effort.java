class Solution {
    class Pair implements Comparable<Pair>{
        int node;
        int jump;
        int maxDist;
        int row;
        int col;
        Pair(int row,int col,int jump,int maxDist)
        {
            this.row=row;
            this.col=col;
            this.jump=jump;
            this.maxDist=maxDist;
        }
        public int compareTo(Pair other)
        {
            return this.jump-other.jump;
        }
        
    }
    int [][]dir={{0,1},{1,0},{-1,0},{0,-1}};
    public int minimumEffortPath(int[][] mat) {
      PriorityQueue<Pair> pq=new PriorityQueue<>();  
        pq.add(new Pair(0,0,0,0));
        while(pq.size()>0)
        {
            Pair front=pq.remove();
            if(front.row==mat.length-1&&front.col==mat[0].length-1) return front.maxDist;
            if(mat[front.row][front.col]==-1) continue;
            for(int i=0;i<4;i++)
            {
             int nr=front.row+dir[i][0];
                int nc=front.col+dir[i][1];
                if(nr<0||nc<0||nr>=mat.length||nc>=mat[0].length)
                    continue;
                int jump=Math.abs(mat[front.row][front.col]-mat[nr][nc]);
                int max=Math.max(jump,front.maxDist);
             pq.add(new Pair(nr,nc,jump,max)); 
            }
            mat[front.row][front.col]=-1;
        }
        return 0;
    }
}