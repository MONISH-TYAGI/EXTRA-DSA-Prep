class Solution {
    public int[] singleNumber(int[] arr) {
    int xxor=0;
   for(int a:arr)
   xxor^=a;
   int rmsb=xxor&-xxor;
   int x=0;
   int y=0;
   for(int val:arr)
   {
       if((val&rmsb)==0)
       {x=x^val;
           
       }else
       {
           y=y^val;
       }
   }
   if(x<y)
   {
       return new int[]{x,y};
   }
   else
   {
           return new int[]{y,x};
   }    
    }
}