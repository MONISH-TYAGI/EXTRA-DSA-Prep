class Solution {
    public int numSteps(String s) {
       StringBuilder res=new StringBuilder(s);
        int step=0;
        while(res.length()>1)
        {
            if(res.charAt(res.length()-1)=='0')
            {
                res.deleteCharAt(res.length()-1);
                step++;
                continue;
            }
            boolean check=false;
            for(int i=res.length()-1;i>=0;i--)
            {
                if(res.charAt(i)=='0')
                {
                    res.setCharAt(i,'1');
                    check=true;
                    break;
                }
res.setCharAt(i,'0');
            }
            if(check!=true)
                res=res.append('1').reverse();
                step++;
        }
        return step;
    }
}