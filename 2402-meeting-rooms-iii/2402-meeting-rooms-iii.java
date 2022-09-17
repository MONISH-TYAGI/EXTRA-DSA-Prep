class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->{
            return a[0]-b[0];
        });
        long []endMeeting=new long[n];
        Arrays.fill(endMeeting,0l);
        int []countRooms=new int[n];

        for(int i=0;i<meetings.length;i++)
        {
            boolean flag=false;
            int start=meetings[i][0];
            int end=meetings[i][1];
            int minIdx=-1;
            long maxVal=Long.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(endMeeting[j]<maxVal)
                {maxVal=endMeeting[j];
                    minIdx=j;
                }
                if(endMeeting[j]<=start)
                {
                    flag=true;
                    countRooms[j]++;
                    endMeeting[j]=end;
                    break;
                }
            }
            if(flag==false)
            {
                countRooms[minIdx]++;
                endMeeting[minIdx]+=(1l*(end-start));
            }
        }
        int maxa=-1,idx=-1;
        for(int i=0;i<n;i++)
        {
            if(countRooms[i]>maxa){maxa=countRooms[i];idx=i;}
        }
        return idx;
    }
}