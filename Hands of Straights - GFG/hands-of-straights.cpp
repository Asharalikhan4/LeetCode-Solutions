//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool isStraightHand(int N, int groupSize, vector<int> &hand) {
        // code here
        map<int,int> mp;
        for(int i=0;i<N;i++) mp[hand[i]]++;
        for(int i=0;i<groupSize;i++){
            auto it=mp.begin();
            int start=it->first;
            for(int j=0;j<groupSize-1;j++){
                if(mp.find(start+1)==mp.end()) return false;
                mp[start]--;
                if(mp[start]==0) mp.erase(start);
                start++;
            }
            mp[start]--;
            if(mp[start]==0) mp.erase(start);
        }
        return true;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int N, groupSize;
        cin >> N >> groupSize;

        vector<int> hand(N);
        for (int i = 0; i < N; i++) cin >> hand[i];

        Solution obj;
        int ans = obj.isStraightHand(N, groupSize, hand);
        if (ans)
            cout << "True" << endl;
        else
            cout << "False" << endl;
    }
    return 0;
}
// } Driver Code Ends