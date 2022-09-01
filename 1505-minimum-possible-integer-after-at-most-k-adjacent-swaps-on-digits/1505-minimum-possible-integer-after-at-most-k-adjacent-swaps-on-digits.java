class Solution {
    public String minInteger(String num, int k) {
        
        char[] ca = num.toCharArray();
        helper(ca, k, 0);
        return new String(ca);
        
    }
    
    
    
    public char[] helper(char[] num,int k,int i){
        if(k==0  || i==num.length-1){
            return num;
        }
        char min=num[i];
        int index=i;
        for(int j=i+1;j<Math.min(num.length,i+k+1);j++){
            char n=num[j];
            if(n<min){
                    
                    min=n;
                    index=j;
                }    
            }
        
        for (int j = index; j>i; j--) {num[j]=num[j-1];}
        num[i] = min;
        
        return helper(num,k-(index-i),i+1);  
        
    }
}
