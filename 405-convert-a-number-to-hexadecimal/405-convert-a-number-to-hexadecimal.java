class Solution {
    public String toHex(int num) {
        if(num==0) return "0";
        long n=num*1l;
        if(n<0)
            n+=Math.pow(2,32);
             long p=1;
        long b=16;
        char[]arr={'a','b','c','d','e','f'};
       StringBuilder res=new StringBuilder();
       while(n>0)
       {
           long dig=n%b;
           n=n/b;
           long c=p*dig;
           if(c>9&&c<16)
           {
        res.append(arr[(int)c-10]);       
           }
           else
           {
               res.append(c);
           }
           
       }
        
       return res.reverse().toString(); 
    }
}