class Solution {
public:
    int numRescueBoats(vector<int>& people, int limit) {
     sort(people.begin(),people.end());
        int cnt=0;
     int left=0,right=people.size()-1;
        while(left<=right)
        {
            int sum=people[left]+people[right];
            if(sum<=limit)
            {
                cnt++;
                left++;
                right--;
            }else
            {
                if(people[left]>people[right])
                {
                    cnt++;
                    left++;
                }else
                {
                    cnt++;
                    right--;
                }
            }
        }
        return cnt;
    }
};