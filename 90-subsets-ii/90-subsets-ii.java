class Solution {
    List<List<Integer>> ans;
    public void findUniqueSubset(int currIdx,HashMap<Integer,Integer>hm,ArrayList<Integer> unique,List<Integer> subans)
    {
        if(currIdx==unique.size())
        {
            List<Integer> obj=new ArrayList<>(subans);
            ans.add(obj);
            return ;
        }
        int ch=unique.get(currIdx);
        int freq=hm.get(ch);
        for(int i=0;i<=freq;i++)
        {
       for(int j=1;j<=i;j++)
           subans.add(ch);
    findUniqueSubset(currIdx+1,hm,unique,subans);
        for(int j=1;j<=i;j++)
           subans.remove(subans.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans=new ArrayList<>();
        HashMap<Integer,Integer> hm=new HashMap<>();
        ArrayList<Integer> unique=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i])==false)
            {
                hm.put(nums[i],1);
                unique.add(nums[i]);
            }
            else
                hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }
  findUniqueSubset(0,hm,unique,new ArrayList<>());
        return ans;
    }
}