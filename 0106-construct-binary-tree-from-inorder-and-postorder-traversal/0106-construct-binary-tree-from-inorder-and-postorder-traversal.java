class Solution {
    public TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> inorder, int inL, int inR, int postL,int postR){
 if(inL > inR) return null;
        // if(postR>=postorder.length) return null;
        TreeNode curr = new TreeNode(postorder[postR]);
        int idx=inorder.get(postorder[postR]);
curr.left=buildTree(postorder,inorder,inL,idx-1,postL,postR-(inR-idx)-1);
        curr.right=buildTree(postorder,inorder,idx+1,inR,postR-(inR-idx),postR-1);
        return curr;

    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);
        
        return buildTree(postorder, hm, 0, inorder.length - 1,0, postorder.length-1);


    }
}