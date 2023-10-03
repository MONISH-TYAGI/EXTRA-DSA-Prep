class Solution {
public:
    bool winnerOfGame(string str) {
     int cA=0,cB=0;
        for(int i=0;i<str.length();i++)
        {
              int start=i;
            if(str[i]=='A')
            {
              
                while(start<str.length()&&str[start]=='A')
                {
                    start++;
                }
                int ans=start-i;
                cA+=max(0,ans-2);
                
            }else 
            {
                 while(start<str.length()&&str[start]=='B')
                {
                    start++;
                }
                int ans=start-i;
                cB+=max(0,ans-2);
            }
            if(i!=start)
            i=start-1;
            
            
        }
        if(cA>cB) return true;
        return false;
    }
};