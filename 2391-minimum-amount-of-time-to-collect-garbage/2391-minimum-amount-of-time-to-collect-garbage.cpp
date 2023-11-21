class Solution {
public:
    int garbageCollection(vector<string>& garbage, vector<int>& travel) {
     //M ,P, G
     int lastM=0,lastP=0,lastG=0;
    for(int i=garbage.size()-1;i>=0;i--)
    {
        string str=garbage[i];
        for(int j=0;j<str.length();j++)
        {
            if(str[j]=='M'&&lastM==0)
                lastM=i;
            else if(str[j]=='P'&&lastP==0)
                lastP=i;
            else if(str[j]=='G'&&lastG==0)
                lastG=i;
        }
    }
        int ans=0;
    int cntM=0,cntP=0,cntG=0;
for(int i=0;i<=lastM;i++)
{
    string str=garbage[i];
    for(int j=0;j<str.length();j++)
    {
        if(str[j]=='M')
            cntM++;
    }
    if(i-1>=0)
        cntM+=travel[i-1];
        
}
        for(int i=0;i<=lastP;i++)
{
    string str=garbage[i];
    for(int j=0;j<str.length();j++)
    {
        if(str[j]=='P')
            cntP++;
    }
    if(i-1>=0)
        cntP+=travel[i-1];
        
}
        for(int i=0;i<=lastG;i++)
{
    string str=garbage[i];
    for(int j=0;j<str.length();j++)
    {
        if(str[j]=='G')
            cntG++;
    }
    if(i-1>=0)
        cntG+=travel[i-1];
        
}
        ans=cntM+cntP+cntG;
        return ans;
        
    }
};