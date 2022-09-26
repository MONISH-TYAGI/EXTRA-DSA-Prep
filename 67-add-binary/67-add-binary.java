class Solution {
       public String getSum(int b, String n1, String n2){
       // write ur code here

       long c=0;
           int i=n1.length()-1;
           int j=n2.length()-1;
           StringBuilder sum=new StringBuilder();
       while(i>=0||j>=0||c>0)
       {
           
           long d1=(i>=0)?n1.charAt(i)-'0':0;
           
           long d2=(j>=0)?n2.charAt(j)-'0':0;

           i--;
           j--;
           long d=d1+d2+c;
           long dig=d%b;
           c=d/b;
           sum.append(dig);
       }
       return sum.reverse().toString();
   }
    public String addBinary(String a, String b) {
       
        return getSum(2,a,b);
    }
}