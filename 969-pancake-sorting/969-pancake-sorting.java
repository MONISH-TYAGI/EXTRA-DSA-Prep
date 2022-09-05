class Solution {
    public void reverse(int []arr,int l,int r)
    {
        while(l<r)
        {
            int temp= arr[l];
                arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }
    }
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for(int i=n-1;i>=0;i--)
        {
            int maxIdx=i;
            for(int j=i-1;j>=0;j--)
                maxIdx=(arr[maxIdx]<arr[j])?j:maxIdx;
            if(maxIdx!=i)
            {
                reverse(arr,0,maxIdx);
                ans.add(maxIdx+1);
                reverse(arr,0,i);
                ans.add(i+1);
            }
        }
        return ans;
    }
}