class Solution {
    public boolean isValid(String s) {
     Stack<Character> stk=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='c')
            {
                if(stk.size()>=2&&stk.pop()=='b'&&stk.pop()=='a')
                {
                    
                }else return false;
            }else
                stk.push(ch);
        }
        return (stk.size()==0);
    }
}