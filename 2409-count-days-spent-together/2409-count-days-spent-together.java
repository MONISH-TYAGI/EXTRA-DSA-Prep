class Solution {
    int []months={31,28,31,30,31,30,31,31,30,31,30,31};
    public int findDays(String str)
    {
        int date=Integer.valueOf(str.substring(3,5));
        int month=Integer.valueOf(str.substring(0,2));
        int days=date;
        for(int i=0;i<month-1;i++)
            days+=months[i];
        return days;
        
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int Aarr=findDays(arriveAlice);
        int Alarr=findDays(leaveAlice);
        int Barr=findDays(arriveBob);
        int Blarr=findDays(leaveBob);
        int arr=Math.max(Aarr,Barr);
        int leave=Math.min(Alarr,Blarr);
        if(leave<arr)
            return 0;
        return leave-arr+1;
    }
}