class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int left=0;
        int n=chargeTimes.length;
        long []prefixSum=new long[n+1];
        prefixSum[1]=runningCosts[0];
        for(int i=2;i<=n;i++)
        {
            prefixSum[i]=prefixSum[i-1]+runningCosts[i-1];
        }
            PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        int ans=0;
    
        for(int right=1;right<prefixSum.length;right++)
        {
            pq.add(chargeTimes[right-1]);
            while(left<right&&(prefixSum[right]-prefixSum[left])*(right-left)+pq.peek()>budget)
            {
               
                   pq.remove(chargeTimes[left]);
                   left++;
                
            }
    // System.out.println(right-left+" - "+right+" and "+left);
            ans=Math.max(ans,right-left);
        }
        return ans;
    }
}