class Solution {

    public boolean isPalindrome(int x) {
      if(x<0) return false;
int res=0;
        int check=x;
    
        while(check>0)
        {
            int lastdigit=check%10;
            res=res*10+lastdigit;
            check=check/10;
        }
        System.out.println(res);
        return (res==x);
        
    }
}