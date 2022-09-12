class Solution {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        TreeNode ol = root.left;
        TreeNode or = root.right;

        if(prev != null){
            prev.left = null;
            prev.right = root;
        }
        prev = root;

        flatten(ol);
        flatten(or);
    }
}
