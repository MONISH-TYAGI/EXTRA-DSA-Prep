class Solution {
    public String intToRoman(int num) {
        int []divisor={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []denote={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder ans=new StringBuilder("");
        for(int i=0;i<divisor.length;i++)
        {
            int fact=num/divisor[i];
         while(fact-->0)
         {
             ans.append(denote[i]);
         }
         num=num%divisor[i];   
        }
        return ans.toString();
    }
}