class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder res1=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
             Boolean flag = Character.isDigit(s.charAt(i));
            ch=Character.toLowerCase(ch);
            if(ch>='a'&&ch<='z'||flag==true)
                res1.append(ch);
        }
       int left=0;
        int right=res1.length()-1;
        while(left<right)
        {
            if(res1.charAt(left)!=res1.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
      
    }
}