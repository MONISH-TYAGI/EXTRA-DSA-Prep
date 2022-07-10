class Solution {
    List<List<Integer>> ans;
    public void findComb(int currIdx,int []candidates,int target,ArrayList<Integer> subans)
    {
        if(target==0)
        {
List<Integer> obj=new ArrayList<>(subans);
            ans.add(obj);
            return ;
        }
        if(currIdx==candidates.length) return ;
        int val=candidates[currIdx];
        for(int i=0;(target-(i*val)>=0);i++)
        {
            for(int j=1;j<=i;j++)
            {
                subans.add(val);
            }
            findComb(currIdx+1,candidates,(target-(i*val)),subans);
            for(int j=1;j<=i;j++)
            {
                subans.remove(subans.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans=new ArrayList<>();
        findComb(0,candidates,target,new ArrayList<>());
        return ans;
    }
}