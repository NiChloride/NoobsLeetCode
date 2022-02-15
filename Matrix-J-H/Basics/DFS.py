class Solution:
    """
    @param grid: a boolean 2D matrix
    @return: an integer
    """
    
    def numIslands(self, grid):
        # write your code here
        nx = len(grid)
        if nx == 0:
            return 0
        ny = len(grid[0])
        count = 0

        for i in range(nx):
            for j in range(ny):
                if grid[i][j] == 1:
                    DFS(i, j, grid, nx, ny)
                    count += 1

        return count
                    
def DFS(i, j, mapp, r, c): 
    if i < 0 or i >= r or j < 0 or j >= c or mapp[i][j] != 1:
        return 

    mapp[i][j] = 2

    DFS(i-1,j, mapp, r, c)
    DFS(i, j+1, mapp, r, c)
    DFS(i+1, j, mapp, r, c)
    DFS(i, j-1, mapp, r, c)