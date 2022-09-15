class Solution {
    public TreeNode buildTree(int[] postorder, HashMap<Integer, Integer> inorder, int inL, int inR, int preIdx){
 if(inL > inR) return null;
        
        TreeNode curr = new TreeNode(postorder[preIdx]);
        int inIdx = inorder.get(postorder[preIdx]);
        
        curr.left = buildTree(postorder, inorder, inL, inIdx - 1, preIdx -1-(inR-inIdx));
        curr.right = buildTree(postorder, inorder, inIdx + 1, inR, preIdx -1);
        return curr;

    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       

        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<inorder.length; i++) hm.put(inorder[i], i);
        
        return buildTree(postorder, hm, 0, inorder.length - 1, postorder.length-1);


    }
}