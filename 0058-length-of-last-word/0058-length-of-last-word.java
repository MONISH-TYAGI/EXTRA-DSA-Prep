class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        char []arr=s.toCharArray();
        int count=0;
        boolean flag=false;
        for(int i=arr.length-1;i>=0;i--)
        {
            if(arr[i]!=' ')
            {
                count++;
            }else
                break;
        }
        return count;
    }
}