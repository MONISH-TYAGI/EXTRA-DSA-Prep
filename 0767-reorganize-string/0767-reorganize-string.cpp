class Solution {
public:
    class Compare {
public:
    bool operator()(pair<char,int> a,pair<char,int> b)
    {
        return (a.second<b.second);

    }
};
    string reorganizeString(string s) {
       unordered_map<char,int> mp;
        for(int i=0;i<s.length();i++)
            mp[s[i]]++;
         priority_queue<pair<char,int>,vector<pair<char,int>>,Compare> pq;
        for(auto it=mp.begin();it!=mp.end();it++)
        {
            pq.push({it->first,it->second});
            cout<<it->first<<" "<<it->second<<endl;
        }
         pair<char,int> st;
                    st.first='-';
             auto       a=st;
         pair<char,int> st2;
                    st2.first='-';
                  auto  b=st2;
        if(pq.size()>0){
         a=pq.top();
        
        pq.pop();
        }
       
        if(pq.size()>0){
         b=pq.top();
        pq.pop();
        }
         cout<<"hello"<<endl;
        string ans="";
        while(a.first!='-'&&b.first!='-')
        {
            ans+=a.first;
            ans+=b.first;
            a.second--;
            b.second--;
            cout<<a.first<<" "<<b.first<<endl;
            cout<<a.second<<" "<<b.second<<endl;
            
            if(a.second>0)
                pq.push(a);
            if(b.second>0)
                pq.push(b);
           
                if(pq.size()>0){
                    a=pq.top();
                    pq.pop();
                }
                else
                break;
            

                if(pq.size()>0)
                {
                    b=pq.top();
                    pq.pop();
                }
                else
                break;
            
        }
    if(a.second==0&&b.second==0) return ans;
    if(a.second==0||b.second==0)
    {
        if(b.second==0)
        {
          if(a.second==1)
          {
              if(ans.length()==0||ans[ans.length()-1]!=a.first)
              {
                  ans+=a.first;
                  return ans;
              }else if(ans[0]!=a.first)
                       {
                           string ans2=a.first+"";
                        return (ans2+ans);
                       }
              else
                  return "";
          }else if(a.second==2)
          {
             if(ans.length()>0&&ans[0]!=a.first&&ans[ans.size()-1]!=a.first)
             {
                 string ans3="";
                 ans3+=a.first;
                 ans3+=ans;
                 ans3+=a.first;
                 return ans3;
             }else
                 return "";
          }else
              return "";
        }else if(a.second==0)
        {
             if(b.second==1)
          {
              if(ans[ans.length()-1]!=b.first)
              {
                  ans+=b.first;
                  return ans;
              }else if(ans[0]!=b.first)
                       {
                           string ans2="";
                  ans2+=b.first;
                        return (ans2+ans);
                       }
              else
                  return "";
          }else
              return "";
        }
    }
        return "";
    }
};