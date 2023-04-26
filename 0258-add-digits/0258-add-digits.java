class Solution {
    public int addDigits(int num) {
        int sum=num;
        String word=num+"";
        while(word.length()>1){
            sum=0;
        for(int i=0;i<word.length();i++)
        {
            sum+=word.charAt(i)-'0';
            
        }
            word=sum+"";
        }
        return sum;
    }
}