class Solution {
    public int compress(char[] chars) {
        StringBuilder res=new StringBuilder("");
        char ch=chars[0];
        int count=1;
        for(int i=1;i<chars.length;i++)
        {
            char curr=chars[i];
            if(ch==curr)
                count++;
            else
            {
                if(count==1)
                {
                    res.append(ch);
                    count=1;
                    
                }else
                {
                    res.append(ch);
                    res.append(count+"");
                    count=1;
                    
                }
                ch=chars[i];
            }
        }
        if(count>1)
        {
            res.append(ch);
                    res.append(count+"");
            
        }
        else if(count==1)
        {
            res.append(ch);
            
        }
    
        int idx=0;
        for(char ch1:res.toString().toCharArray())
            chars[idx++]=ch1;
    
        return res.length();
    }
}