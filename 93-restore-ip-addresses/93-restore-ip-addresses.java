class Solution {
    List<String> obj;
    public void combination(String ans,String ques,int dots)
    {
        if(dots==3)
        {
            if(ques.length()>1&&ques.charAt(0)=='0') return ;
           if(ques.length()!=0)
           {
               Long val=Long.parseLong(ques);
               if(val>=0&&val<=255)
             obj.add(ans+ques);
           }
            return ;
        }
        if(ques.length()==0) return ;
        String one=ques.substring(0,1);
        Long val=Long.parseLong(one);
        if(val>=0&&val<=255)
        combination(ans+one+".",ques.substring(1),dots+1);
        if(val!=0){
            if(ques.length()>=2){
                String two=ques.substring(0,2);
        Long value=Long.parseLong(two);
        if(value>=0&&value<=255)
        combination(ans+two+".",ques.substring(2),dots+1);
            }
            if(ques.length()>=3){
                String three=ques.substring(0,3);
        Long temp=Long.parseLong(three);
        if(temp>=0&&temp<=255)
        combination(ans+three+".",ques.substring(3),dots+1);
            }
        }
        
    }
    public List<String> restoreIpAddresses(String s) {
       obj=new ArrayList<>();
        combination("",s,0);
        return obj;
    }
}