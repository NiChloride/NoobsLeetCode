

//UnionFind-----------------------------------------------------------
class Solution {
public:
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    
    int pre[100000];
    int ans = 0;
    
    int unionfind(int root){ //查找岛屿根节点
    	int son, tmp;
	    son = root;
	    while(root != pre[root])
	    	root = pre[root];
	    while(son != root)   //路径压缩
	    {
		    tmp = pre[son];
		    pre[son] = root;
		    son = tmp;
	    }
	    return root;
    }
    
    void connect(int A, int B){  //连接A和B两个点
        int rootA = unionfind(A);
        int rootB = unionfind(B);
        if(rootA != rootB){
            pre[rootB] = rootA;
            ans--;
        }
    }
    
    int numIslands(vector<vector<bool>> &grid) {
        if(grid.size()==0)return 0;
        int n = grid.size(), m = grid[0].size();
        map<pair<int,int>,int> index;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]){
                    pair<int,int> tmp(i,j);
                    pre[ans] = ans;
                    index[tmp] = ans++;
                }
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]){
                    pair<int,int> now(i,j);
                    if(i+1 < n && grid[i+1][j]){
                        pair<int,int> up(i+1,j);
                        connect(index[up],index[now]);
                    }
                    if(j+1 < m && grid[i][j+1]){
                        pair<int,int> left(i,j+1);
                        connect(index[left],index[now]);
                    }
                }
            }
        }
        return ans;
    }
};