class Solution {
    public static boolean isPossible(int []dist,double hr,int speed)
    {

        double hrpass=0;
        for(int i=0;i<dist.length-1;i++)
        {
            hrpass+=dist[i]/speed;
            hrpass+=(dist[i]%speed==0)?0:1;
        }
        hrpass+=(dist[dist.length-1]*1.0/speed);
                // if(speed==4)
                    // System.out.println("hr "+hrpass+" bool "+(hrpass<=hr));
        return hrpass<=hr;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        if((double)dist.length-1>=hour) return -1;
        int  left=1;
        int  right=10000000;
        int ans=right;
        while(left<=right)
        {
int mid=left+((right-left)/2);
    // if(mid<=9)
        // System.out.println(mid);
            if(isPossible(dist,hour,mid))
            {
                ans=mid;
                right=mid-1;

            }
            else
                left=mid+1;
        }
        // if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}