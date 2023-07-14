/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<TreeNode*> helper(int start,int end)
    {
          vector<TreeNode *> ans;
        if(start>end)
        {
             ans.push_back(NULL);
            return ans;
        }
       
        for(int i=start;i<=end;i++)
        {
            vector<TreeNode*> leftSubtree=helper(start,i-1);
            vector<TreeNode*> rightSubtree=helper(i+1,end);
            for(int j=0;j<leftSubtree.size();j++)
            {
                for(int k=0;k<rightSubtree.size();k++)
                {
                    TreeNode* curr=new TreeNode(i);
                    curr->left=leftSubtree[j];
                    curr->right=rightSubtree[k];
                    ans.push_back(curr);   
                }
            }
        }
        return ans;
    }
    vector<TreeNode*> generateTrees(int n) {
         return helper(1,n);
    }
};