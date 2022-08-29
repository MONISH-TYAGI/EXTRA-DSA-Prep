class Solution {
    public int romanToInt(String s) {
     HashMap<String,Integer> hm=new HashMap<>();
        int sum=0;
        hm.put("M",1000);
        hm.put("CM",900);
        hm.put("D",500);
        hm.put("CD",400);
        hm.put("C",100);
        hm.put("XC",90);
        hm.put("L",50);
        hm.put("XL",40);
        hm.put("X",10);
        hm.put("IX",9);
        hm.put("V",5);
        hm.put("IV",4);
        hm.put("I",1);
        int number=0;
    for(int i=0;i<s.length();i++)
    {
        char ch=s.charAt(i);
        int val=hm.get(ch+"");
        sum=sum+val;
        // System.out.println("outer->"+sum);
        if(i!=0){
        char prev=s.charAt(i-1);
        int prevVal=hm.get(prev+"");
            // System.out.println("prevVal->"+prevVal+"currVal->"+val);
        if(prevVal<val)
        {
            sum=sum-prevVal;
            sum=sum-val;
            sum=sum+Math.abs(val-prevVal);
         // /  System.out.println("inner"+sum);
        }
        }
    }
        return sum;
    }
}