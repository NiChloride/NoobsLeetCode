
#bfs, numIslands
from collections import deque
class Solution:
    """
    @param grid: a boolean 2D matrix
    @return: an integer
    """
    def bfs(self, grid, i, j):
        q = deque()
        q.append([i,j])
        adjacent_directions = [[1,0],[-1,0],[0,1],[0,-1]]
        while q:
            now = q.pop() #pop first element, return
            for k in range(4):
                adjacent_points = [now[0]+adjacent_directions[k][0],now[1]+adjacent_directions[k][1]]
                if adjacent_points[0]>=0 and adjacent_points[0]<len(grid) and adjacent_points[1]>=0 and adjacent_points[1]<len(grid[0]) and grid[adjacent_points[0]][adjacent_points[1]]:
                    grid[adjacent_points[0]][adjacent_points[1]] = False
                    q.append(adjacent_points)
    def numIslands(self, grid):
        if not grid:
            return 0
        ans = 0
        for i,v in enumerate(grid):
            for j,k in enumerate(grid[i]):
                if k:
                    ans += 1
                    self.bfs(grid, i, j)
        return ans

if __name__ == '__main__':
    input_grid = [
  [1,1,0,0,0],
  [0,1,0,0,1],
  [0,0,0,1,1],
  [0,0,0,0,0],
  [0,0,0,0,1]
  ]
    sol = Solution()
    print(sol.numIslands(input_grid))

    






                