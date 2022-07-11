class Solution {
    List<Integer> res;
    public void  findNumber(int i,int n)
    {
        if(i>n)
            return ;
            res.add(i);
        for(int j=0;j<10;j++)
        {
            findNumber(i*10+j,n);
        }
    }
    public List<Integer> lexicalOrder(int n) {
        res=new ArrayList<>();
        for(int i=1;i<10;i++)
        findNumber(i,n);
        return res;
    }
}