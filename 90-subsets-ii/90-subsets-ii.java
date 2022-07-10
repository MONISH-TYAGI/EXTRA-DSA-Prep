class Solution {
    List<List<Integer>> ans;
    public void findUniqueSubset(int lastIdx,HashMap<Integer,Integer>hm,ArrayList<Integer> unique,List<Integer> subans)
    {
         List<Integer> obj=new ArrayList<>(subans);
        ans.add(obj);
        for(int i=lastIdx;i<unique.size();i++)
        {
            
            int ch=unique.get(i);
            int freq=hm.get(ch);
            if(freq>0)
            {
                hm.put(ch,freq-1);
                subans.add(ch);
                findUniqueSubset(i,hm,unique,subans);
                subans.remove(subans.size()-1);
                hm.put(ch,freq);
            }
            
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