class Solution {
    List<List<Integer>>ans;
public void findCombination(int currBox,int k,int n,List<Integer>subans,int lastIdx)
{
    if(n==0)
    {
        if(subans.size()==k)
        ans.add(new ArrayList<>(subans));
        return ;
    }
    for(int i=lastIdx+1;i<=9;i++)
    {
        if(n-i>=0){
        subans.add(i);
        findCombination(currBox+1,k,n-i,subans,i);
        subans.remove(subans.size()-1);
        }
    }
}
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
    int sum=0;
        for(int i=1;i<=k;i++)
            sum+=i;
        if(sum>n) return ans;
        findCombination(0,k,n,new ArrayList<>(),0);
        return ans;
    }
}