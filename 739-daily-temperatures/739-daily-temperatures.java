class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
                   int  []nge=new int[temperatures.length];
        // HashMap<Integer,Integer> hm=new HashMap<>();
        Arrays.fill(nge,-1);
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<temperatures.length;i++)
        {
            // hm.put(temperatures[i],i);
            while(stk.size()>0&&temperatures[stk.peek()]<temperatures[i])
            {
                nge[stk.pop()]=i;
            }
            stk.push(i);
        }
        for(int i=0;i<nge.length;i++)
        {
            if(nge[i]==-1)nge[i]=0;
            else
                nge[i]=nge[i]-i;
        }
        return nge;
    }
}