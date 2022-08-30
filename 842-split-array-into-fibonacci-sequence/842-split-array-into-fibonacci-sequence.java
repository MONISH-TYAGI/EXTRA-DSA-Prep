class Solution {
    public boolean helper(String s,List<Integer>obj,int pos)
    {
        if(pos==s.length())
        {
            if(obj.size()>2) return true;
            return false;
        }
        int num=0;
        for(int i=pos;i<s.length();i++)
        {
num=num*10+(s.charAt(i)-'0');
            if(num<0) return false;
            if(obj.size()<2||obj.get(obj.size()-1)+obj.get(obj.size()-2)==num)
            {
    obj.add(num);
            if(helper(s,obj,i+1))return true;
                obj.remove(obj.size()-1);
            }
            if(i==pos&&s.charAt(i)=='0') return false;
        }
        return false;
    }
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer>obj=new ArrayList<>();
        helper(num,obj,0);
        return obj;
    }
}