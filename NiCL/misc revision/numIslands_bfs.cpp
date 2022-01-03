

//bfs-----------------------------------------------------------------
class Solution {
public:
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    void bfs(vector<vector<bool>> &grid,int i, int j) {
        pair<int,int> now(i,j);
        queue<pair<int,int>> q;
        int n = grid.size(), m = grid[0].size();
        int dir[4][2] = {1,0,-1,0,0,1,0,-1};
        q.push(now);
        while(!q.empty()){
            now = q.front();
            q.pop();
            for(int k = 0; k < 4; k++){
                pair<int,int> next(now.first+dir[k][0],now.second+dir[k][1]);
                if(next.first>=0 && next.first<n && next.second>=0 && next.second<m && grid[next.first][next.second]){
                    q.push(next);
                    grid[next.first][next.second] = 0;
                }
            }
        }
    }
    
    int numIslands(vector<vector<bool>> &grid) {
        if(grid.size()==0)return 0;
        int n = grid.size(), m = grid[0].size();
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]){
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }
};

