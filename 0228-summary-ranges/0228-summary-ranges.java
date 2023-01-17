class Solution {
    public List<String> summaryRanges(int[] nums) {
        int count=0;
        
        List<String> obj=new ArrayList<>();
        if(nums.length==0)  return obj;
        boolean flag=false;
        int i;
        for( i=0;i<nums.length-1;i++)
        {
if(nums[i]+1==nums[i+1])
    count++;
    else
    {
String res="";
    if(count!=0)
        res=nums[i-count]+"->"+nums[i];
        else
            res=nums[i]+"";
        obj.add(res);
        count=0;
    }

    }
                if(count!=0)
        {
       String res="";

        res=nums[i-count]+"->"+nums[i];
                    
        obj.add(res);
        count=0;     
        }
        else
            obj.add(nums[nums.length-1]+"");
            return obj;
        }
}