class Solution {
    public int numIslands(char[][] grid) {
        int res =0;
        int m = grid.length, n = grid[0].length;
        for(int i =0;i<m;i++){
            for(int j =0 ;j<n ;j++){
                if(grid[i][j]=='1'){
                    res++;
                    bfs(grid,i,j);
                }
            }
        }
        return res;
    }
    
    
    
    private void bfs(char[][] grid, int i, int j){
        
        int m = grid.length, n = grid[0].length;
       
        grid[i][j]='0';
        
        Queue<Integer> queue = new ArrayDeque<>();
        
        queue.offer(i*m+j);
        
        int[][] pos = new int[][]{
            {-1,0},{1,0},{0,1},{0,-1}
        };
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            i = num/m;
            j = num%m;
            for(int[] p : pos){
                int next_i = i + p[0];
                int next_j = j + p[1];
                
                if(next_i<0|| next_i>=m || next_j<0 || next_j>=n || grid[next_i][next_j] == '0' ){
                     continue;
                }
                
                queue.offer(next_i*m+next_j);
                
                grid[next_i][next_j]='0';
                
            }
        }
    }
}