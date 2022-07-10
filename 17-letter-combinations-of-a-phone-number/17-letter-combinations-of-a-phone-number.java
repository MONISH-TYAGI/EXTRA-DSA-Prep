class Solution {
    List<String> res;
    String []comb={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public void findComb(int idx,String asf,String input)
    {
        if(idx==input.length())
        {
            res.add(asf);
            return ;
        }
      int currIdx=input.charAt(idx)-'0';
        String curr=comb[currIdx];
        for(int i=0;i<curr.length();i++)
        {
            findComb(idx+1,asf+curr.charAt(i),input);
        }
    }
    public List<String> letterCombinations(String digits) {
        res=new ArrayList<>();
        if(digits.length()==0)
            return res;
        findComb(0,"",digits);
        return res;
    }
}