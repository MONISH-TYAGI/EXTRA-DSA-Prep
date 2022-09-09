class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
           int  []nge=new int[nums2.length];
        HashMap<Integer,Integer> hm=new HashMap<>();
        Arrays.fill(nge,-1);
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<nums2.length;i++)
        {
            hm.put(nums2[i],i);
            while(stk.size()>0&&nums2[stk.peek()]<nums2[i])
            {
                nge[stk.pop()]=nums2[i];
            }
            stk.push(i);
        }
        int []ans=new int[nums1.length];
        for(int i=0;i<ans.length;i++)
        {
            ans[i]=nge[hm.get(nums1[i])];
        }
        return ans;
    }
}