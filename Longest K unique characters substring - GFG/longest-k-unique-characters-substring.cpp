//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function template for C++

class Solution{
  public:
    int longestKSubstr(string str, int k) {
        // creating all the imp variables -
        map<char,int>mp;
        int i=0,j=0;
        int ans = -1;
        while(j<str.size()){
            //pre-processing -
            mp[str[j]]++;
            if(mp.size()<k){ //window size is not yet hit
                j++;
            }else if(mp.size() == k){   //window size is hit here
                ans = max(ans,j-i+1);   //storing the window size with k unique char
                j++;
            }else if(mp.size()>k){  //need to slide the window
                while(mp.size() > k){
                    mp[str[i]]--;
                    if(mp[str[i]] == 0){
                        mp.erase(str[i]);
                    }
                    i++;
                }
                j++;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        int k;
        cin >> k;
        Solution ob;
        cout << ob.longestKSubstr(s, k) << endl;
    }
}

// } Driver Code Ends