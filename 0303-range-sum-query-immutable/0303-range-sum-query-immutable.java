class NumArray {


    int []pre;
    public NumArray(int[] nums) {
        
        pre=new int[nums.length];
        pre[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i]=nums[i]+pre[i-1];
            
        }
        
        
        
    }
    
    public int sumRange(int left, int right) {
        int leftVal=(left!=0)?pre[left-1]:0;
        int rightVal=pre[right];
        return rightVal-leftVal;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */