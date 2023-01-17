class Solution {
    public boolean checkVowel(char ch)
    {
ch=Character.toLowerCase(ch);
        // System.out.println(ch);
     if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
         return true;
        return false;
    }
    public String reverseVowels(String s) {
        StringBuilder res=new StringBuilder(s);
          int left=0;
        int right=s.length()-1;
        while(left<s.length()&&checkVowel(s.charAt(left))==false)
              left++;
          while(right>0&&checkVowel(s.charAt(right))==false)
              right--;      
              
        while(left<right)
        {
            char ch1=s.charAt(left);
            char ch2=s.charAt(right);
            res.setCharAt(left,ch2);
            res.setCharAt(right,ch1);
            left++;
            right--;
           
            while(left<s.length()&&checkVowel(s.charAt(left))==false)
              left++;
          while(right>0&&checkVowel(s.charAt(right))==false)
              right--;      
        }
        return res.toString();
    }
}