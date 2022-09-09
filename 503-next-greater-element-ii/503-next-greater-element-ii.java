class Solution {
    public int[] nextGreaterElements(int[] arr) {
     int []nge=new int[arr.length];
         Arrays.fill(nge,-1);
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<2*arr.length;i++)
        {
            while(stk.size()>0&&arr[stk.peek()]<arr[i%arr.length])
            {
                nge[stk.pop()]=arr[i%arr.length];
            }
            if(i<arr.length)
            stk.push(i);
        }
        return nge;
    }
}