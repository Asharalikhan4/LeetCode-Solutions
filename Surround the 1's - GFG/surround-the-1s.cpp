//{ Driver Code Starts

#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution {
    int helper(vector<vector<int>> &mat , int x,int y){
        if(x < 0  or x >= mat.size() or y < 0 or y >= mat[0].size() or mat[x][y] == 1){
            return 0;
        }
        return 1;
    }
public:
    int Count(vector<vector<int> >& mat) {
        // Code here
        queue<pair<int,int>> q;
        for(int i = 0 ; i < mat.size() ; i++){
            for(int j = 0; j < mat[0].size();j++){
                if(mat[i][j] == 1){
                    q.push({i,j});
                }
            }
        }
        int dx[] = {0,0,1,-1,-1,-1,1,1};
        int dy[] = {1,-1,0,0,-1,1,-1,1};
        int res = 0;
        while(!q.empty()){
            auto it = q.front();q.pop();
            int cnt = 0;
            for(int i = 0; i < 8 ; i ++){
                cnt += helper(mat,it.first + dx[i],it.second + dy[i]);
            }
            if(cnt != 0 and cnt % 2 == 0){
                res++;
            }
        }
        return res;
    }
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n, m;
		cin >> n >> m;
		vector<vector<int>> matrix(n, vector<int>(m,0));
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				cin >> matrix[i][j];
			}
		}
		Solution ob;
		int ans = ob.Count(matrix);
		cout << ans <<"\n";
	}
	return 0;
}
// } Driver Code Ends