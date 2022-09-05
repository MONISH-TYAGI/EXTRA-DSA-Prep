class Solution {
        int []count;
  public  class Pair{
        int val;
        int idx;
        Pair(int val,int idx)
        {
            this.val=val;
            this.idx=idx;
        }
    }
    public Pair[] merge(Pair[]left,Pair[]right)
    {
        int i=0,j=0,idx=0;
        Pair []pairs=new Pair[left.length+right.length];
        while(i<left.length&&j<right.length)
        {
            if(left[i].val>right[j].val)
            {
                pairs[idx++]=new Pair(left[i].val,left[i].idx);
                if(left[i].idx<right[j].idx)
                    count[left[i].idx]+=right.length-j;
                i++;
            }else
            {
                pairs[idx++]=new Pair(right[j].val,right[j].idx);
                j++;
            }
                
        }
        while(i<left.length)
        {     pairs[idx++]=new Pair(left[i].val,left[i].idx);
         i++;}
        while(j<right.length){
            pairs[idx++]=new Pair(right[j].val,right[j].idx);
            j++;
        }
        
        return pairs;
        }
    public Pair[] mergeSort(int []nums,int low,int high)
    {
        if(low==high)
        {
            Pair obj=new Pair(nums[low],low);
            return new Pair[]{obj};
        }
        if(low>high) return new Pair[0];
        int mid=low+(high-low)/2;
       Pair []left= mergeSort(nums,low,mid);
      Pair []right=  mergeSort(nums,mid+1,high);
//   int i=0,j=0;
//         while(i<left.length&&j<right.length)
//         {
//             Pair one =left[i];
//             Pair two=right[j];
//             if(one.idx<two.idx&&one.val>two.val)
//             {    count[one.idx]+=right.length-j;
//              i++;
//              j=0;
//             }else
//             {
//                 j++;
//                 if(j>=right.length) break;
//                 // { i++;j=0;}
//             }
            
//         }
       return merge(left,right);
    }
    public List<Integer> countSmaller(int[] nums) {
        count=new int[nums.length];
        List<Integer> obj=new ArrayList<>();
        mergeSort(nums,0,nums.length-1);
        for(int a:count)
            obj.add(a);
        return obj;
    }
}