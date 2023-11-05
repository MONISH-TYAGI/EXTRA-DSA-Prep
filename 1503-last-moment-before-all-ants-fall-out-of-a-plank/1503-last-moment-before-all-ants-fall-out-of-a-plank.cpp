class Solution {
public:
    int getLastMoment(int n, vector<int>& left, vector<int>& right) {
        int leftMax=INT_MIN;
        for(int a:left)
        {
            leftMax=max(a,leftMax);
        }
        for(int a:right)
        {
            leftMax=max(leftMax,n-a);
        }
        return leftMax;
    }
};