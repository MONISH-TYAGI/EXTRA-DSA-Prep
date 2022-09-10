class Solution {
    class Pair
    {
int id;
        int st;
        int ct;
        Pair(int x,int y,int z)
        {
            id=x;
            st=y;
            ct=z;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
     int timeF[]=new int[n];
    Stack<Pair>stk=new Stack<>();
        for(int i=0;i<logs.size();i++)
        {
            String log[]=logs.get(i).split(":");
            if(log[1].equals("start"))
            {
             Pair p=new Pair(Integer.parseInt(log[0]),Integer.parseInt(log[2]),0);
                stk.push(p);
            }
            else
            {
                Pair p=stk.pop();
                int interval=Integer.parseInt(log[2])-p.st+1;
                int time=interval-p.ct;
                timeF[p.id]+=time;
                if(stk.size()>0)
                {
                    stk.peek().ct+=interval;
                }
            }
        }
        return timeF;
    }
}