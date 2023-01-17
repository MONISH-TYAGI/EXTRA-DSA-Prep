class Solution {
    public int[] plusOne(int[] digits) {
        // if(digits.length==1)
        // {
        //     digits[0]++;
        //     return digits;
        // }
      
      int []arr=new int[digits.length+1];
          int idx=arr.length-1;
        
        int borrow=1;
        while(idx>=1)
        {
            int val=digits[idx-1]+borrow;
            if(val>=10)
            {
         arr[idx]=0;
                borrow=1;
            }else
            {
                arr[idx]=val;
                borrow=0;
                
            }
            idx--;
        }
        if(borrow==1)
        {
        arr[0]=1;
            return arr;
        }else
        {
int []newArr=new int[digits.length];
            for(int i=0;i<newArr.length;i++)
                newArr[i]=arr[i+1];
            // newArr[0]=digits[0];
            return newArr;
        }
    }
}