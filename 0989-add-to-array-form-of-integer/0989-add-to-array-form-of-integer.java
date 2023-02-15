class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
      int n=num.length;
int digits=(int)(Math.log10(k) + 1);
        int []digArr=new int[digits];
       int idx=digits-1;
        while(k>0)
        {
            digArr[idx]=k%10;
            k=k/10;
            idx--;
        }
        int []BigArr;
        int []smallArr;
        if(n>=digits){
        BigArr=num;
        smallArr=digArr;
        }else
        {
            BigArr=digArr;
            smallArr=num;
        }
        int carry=0;
                    int secondIdx=smallArr.length-1;
        for(int i=BigArr.length-1;i>=0;i--)
        {
            int firstVal=BigArr[i];

            int smallVal=(secondIdx>=0)?smallArr[secondIdx]:0;
            int currVal=firstVal+smallVal+carry;
            BigArr[i]=currVal%10;
            carry=currVal/10;
            secondIdx--;
        }
        ArrayList<Integer> obj=new ArrayList<>();
        if(carry!=0)
        {
            obj.add(1);
        }
        for(int a:BigArr)
            obj.add(a);
        return obj;
    }
}