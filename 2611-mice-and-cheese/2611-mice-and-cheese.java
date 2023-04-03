class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int [][]arr=new int[reward1.length][2];
        for(int i=0;i<reward1.length;i++)
        {
     arr[i][0]=reward1[i];
            arr[i][1]=reward2[i];
        }
        Arrays.sort(arr,(a,b)->{
           return ((b[0]-b[1])-(a[0]-a[1])); 
        });
        for(int i=0;i<arr.length;i++)
        {
           
                // System.out.println(arr[i][0]+" and "+arr[i][1]);/\
        }
        int sum=0;
       for(int i=0;i<k;i++)
           sum+=arr[i][0];
        for(int i=k;i<reward1.length;i++)
            sum+=arr[i][1];
        return sum;
    }
}