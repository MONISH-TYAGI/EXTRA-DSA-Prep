class Solution {
    public void helper(List<String>obj,int open,int close,String ans)
    {
            if(open==0&&close==0)
            {      obj.add(ans);
            return ;
            }
        if(open!=0)
        helper(obj,open-1,close,ans+"(");
        if(open<close)
        helper(obj,open,close-1,ans+")");
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        helper(ans,n-1,n,"(");
        return ans;
    }
}