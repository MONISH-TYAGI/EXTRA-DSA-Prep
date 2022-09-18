class Solution {
    public int minGroups(int[][] intervals) {
        ArrayList<Integer> start=new ArrayList<>();
        ArrayList<Integer>end=new ArrayList<>();
        for(int i=0;i<intervals.length;i++)
        {
            start.add(intervals[i][0]);
            end.add(intervals[i][1]);
        }
        Collections.sort(start);
        Collections.sort(end);
        int startIdx=0;
        int endIdx=0;
        int currRooms=0;
        int maxRooms=0;
        while(startIdx<start.size()&&endIdx<end.size())
        {
            if(start.get(startIdx)<=end.get(endIdx))
            {
              startIdx++;
              currRooms++;
            }
          else  if(start.get(startIdx)>end.get(endIdx))
            {
              endIdx++;
              currRooms--;
            }
            else
            {
                startIdx++;
                endIdx++;
            }
            maxRooms=Math.max(currRooms,maxRooms);
        }
        return maxRooms;
    }
}