#define ll long long
#define mod 1000000007
class Solution {
public:
    
    ll solve(int currPos,int usedSong,int goal,int N,int k,vector<vector<ll>> &dp)
    {
        if(currPos==goal)
            return (usedSong==N);
        if(dp[usedSong][currPos]!=-1 ) return dp[usedSong][currPos];
    ll usedSongPlay=((solve(currPos+1,usedSong,goal,N,k,dp)%mod)*(max(0,usedSong-k)%mod))%mod;
        ll newSongPlay=((solve(currPos+1,usedSong+1,goal,N,k,dp)%mod)*((N-usedSong)%mod))%mod;
        ll total=(usedSongPlay+newSongPlay)%mod;
        return dp[usedSong][currPos]=total;
    }
    int numMusicPlaylists(int n, int goal, int k) {
        
        vector<vector<ll >> dp(goal+1,vector<ll>(goal+1,-1));
        return (int)solve(0,0,goal,n,k,dp);
    }
};