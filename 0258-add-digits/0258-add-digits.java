class Solution {
    public int addDigits(int nums) {
      while(nums>9)
      {
          String res=nums+"";
          int sum=0;
          for(int i=0;i<res.length();i++)
          {
              int dig=res.charAt(i)-'0';
              sum+=dig;
          }
          nums=sum;
      }
        return nums;
    }
}