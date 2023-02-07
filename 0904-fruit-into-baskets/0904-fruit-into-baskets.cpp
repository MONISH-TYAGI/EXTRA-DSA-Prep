class Solution {
public:
    int totalFruit(vector<int>& fruits) {
set<int>s;
        for(int i:fruits)s.insert(i);
        if(s.size()<=2) return fruits.size();
        int j=0;
        int total=0;
        vector<int>f(100005);
        fruits.push_back(100001);
              int n=fruits.size();
        
        int maxi=0;
        for(int i=0;i<n;i++)
        {
            if(total==2&&f[fruits[i]]==0)
            {
                maxi=max(maxi,i-j);
              //  cout<<"i-> "<<i<<" j-> "<<j;
                while(j<i)
                {
                    if(f[fruits[j]]>1)
                    {    f[fruits[j]]--;
                    j++;}
                    else if(f[fruits[j]]==1)
                    {
                        f[fruits[j]]--;
                        j++;
                        break;
                    }
                }
                f[fruits[i]]++;
            }else if(f[fruits[i]]==0)
            {
                                total++;
                f[fruits[i]]++;
            }else
            {

                f[fruits[i]]++;
            }
        }
        return maxi;  
    }
};