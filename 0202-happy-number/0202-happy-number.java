class Solution {
    public boolean isHappy(int n) {
        
        HashSet<Integer> hm=new HashSet<>();
        while(true)
        {
            String res=n+"";
            int sum=0;
            for(char ch:res.toCharArray())
            {
                int dig=ch-'0';
                sum+=(dig*dig);
            }
            if(sum==1) return true;
            if(hm.contains(sum)==true) return false;
            hm.add(sum);
            n=sum;
        }
        // if(n==1)
        //     return true;
        // return false;
    }
}