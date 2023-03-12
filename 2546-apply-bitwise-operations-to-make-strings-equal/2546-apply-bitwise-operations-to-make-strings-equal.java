class Solution {
    public boolean makeStringsEqual(String s, String t) {
                if(s.equals(t)==true){
            return true;
        }
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' && (s.charAt(i)==t.charAt(i))){
                return true;
            }
        }
        
        int flag=0,flg=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1' && t.charAt(i)=='0'){
                flag=1;
            }
            else if(s.charAt(i)=='0' && t.charAt(i)=='1'){
                flg=1;
            }
            
        }
        
        if(flag==1&& flg==1){
            return true;
        }
        
        return false;
    }
}