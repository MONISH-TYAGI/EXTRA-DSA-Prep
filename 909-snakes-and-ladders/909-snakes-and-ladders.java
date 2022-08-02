class Solution {
    public int snakesAndLadders(int[][] board) {
        ArrayList<Integer> gameCell=new ArrayList<>();
        gameCell.add(0);
        int level=0;
        int cell=1;
        for(int i=board.length-1;i>=0;i--)
        {
            if(level%2==0)
            {
              for(int j=0;j<board[i].length;j++)
              {
                  if(board[i][j]==-1)
                  gameCell.add(cell);
                  else
                      gameCell.add(board[i][j]);
                  cell++;
              }
            }else
            {
             for(int j=board[0].length-1;j>=0;j--)
              {
                  if(board[i][j]==-1)
                  gameCell.add(cell);
                  else
                      gameCell.add(board[i][j]);
                  cell++;
              }  
            }
            level++;
        }
        // System.out.println(gameCell);
        int size=board.length*board[0].length;
        ArrayList<Integer>[]adj=new ArrayList[size+1];
        for(int i=0;i<=size;i++)
            adj[i]=new ArrayList<>();
        for(int i=1;i<=size;i++)
        {
            for(int j=1;j<=6;j++)
            {
                if(i+j<=size&&gameCell.get(i+j)!=i)
                {
                    // System.out.println("->"+i+j);
                adj[i].add(gameCell.get(i+j));
                }
            }
        }
        return BFS(adj);
    }
    class Pair{
        int curr;
        int move;
        Pair(int curr,int move)
        {
            this.curr=curr;
            this.move=move;
        }
    }
    public int BFS(ArrayList<Integer>[]adj)
    {
        Queue<Pair>q =new ArrayDeque<>();
        q.add(new Pair(1,0));
        //System.out.println("->"+adj.length);
        int []vis=new int[adj.length];
        Arrays.fill(vis,-1);
        while(q.size()>0)
        {
            Pair front=q.remove();
            if(vis[front.curr]!=-1)
                continue;
            vis[front.curr]=front.move;
            for(int nbr:adj[front.curr])
            {
                q.add(new Pair(nbr,front.move+1));
            }
        }
//         System.out.println();
// for(int a:vis)
//     System.out.print(a+" ");
        return vis[adj.length-1];
    }
}