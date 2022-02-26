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

    '''BFS
    def numIslands(self, grid: List[List[str]]) -> int:
        q = deque()
        
        cnt = 0
        
        def AddLand(row, col):
            if 0 <= row < len(grid) and 0 <= col < len(grid[0]) and grid[row][col] == "1":
                q.append((row, col))
        
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] != "1":
                    continue
                else:
                    AddLand(i, j)
                    cnt += 1
                
                while q:
                    r, c = q.pop()
                    grid[r][c] = "2"
                    
                    for nrow, ncol in ((-1, 0), (0, -1), (0, 1), (1, 0)):
                        AddLand(r + nrow, c + ncol)
        
        return cnt
    '''                   


    '''
    #Answer from 博哥
    def numIslands(self, grid) -> int:
        import queue
        q = queue.Queue()
        r = 0
        visited = []
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == "1" and [i, j] not in visited:
                    q.put([i, j])
                    r += 1
                    print(r)
                    while not q.empty():
                        island = q.get()
                        row, col = island[0], island[1]
                        for direction in directions:
                            r = row + direction[0]
                            c = col + direction[1]
                            if row < 0 or col < 0 or row >= len(
                                    grid) or col >= len(grid[0]) or grid[row][col] == "0":
                                continue
                            q.put([r, c])
                            visited.append([r, c])
        return r
    '''
