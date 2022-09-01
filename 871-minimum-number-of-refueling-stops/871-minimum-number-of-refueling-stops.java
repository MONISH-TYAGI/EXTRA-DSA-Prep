class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
       int max_you_can_reach=startFuel;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        int count=0;
        int index=0;
        while(max_you_can_reach<target)
        {
while(index<stations.length&&stations[index][0]<=max_you_can_reach)
{
    pq.add(stations[index][1]);
    index++;
}
            if(pq.size()==0) return -1;
            max_you_can_reach+=pq.remove();
            count++;
            }
return count;
    }
}