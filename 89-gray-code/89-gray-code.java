class Solution {
    public List<String> helper(int n)
    {
        if(n==1)
        {
            List<String> obj=new ArrayList<>();
            obj.add("0");
            obj.add("1");
            return obj;
        }
        List<String> resMinusOne=helper(n-1);
        List<String> res=new ArrayList<>();
        for(String a:resMinusOne)
        {
            res.add("0"+a);
        }
        for(int i=resMinusOne.size()-1;i>=0;i--)
        {
            String b=resMinusOne.get(i);
            res.add("1"+b);
        }
        return res;
    }
    public List<Integer> grayCode(int n) {
        List<String> obj= helper(n);
        List<Integer>ans=new ArrayList<>();
        for(String a:obj)
        {
            int decimal=Integer.parseInt(a,2); 
            ans.add(decimal);
        }
        return ans;
    }
}