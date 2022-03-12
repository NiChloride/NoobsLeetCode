from typing import (
    List,
)
from collections import deque


class Solution:
    """
    @param grid: a chessboard included 0 and 1
    @return: the shortest path
    """
    def shortest_path2(self, grid: List[List[bool]]) -> int:
        steps = [(1,2), (-1,2), (2,1), (-2,1)]
        q = deque()
        q.append((0,0)) #starting point
        res = 0
        n = len(grid)
        m= len(grid[0])
        if grid[n-1][m-1]==1:
            return -1

        while(len(q)):
            len_q = len(q)
            res += 1
            for i in range(len_q):
                if q[0][0] == n-1 and q[0][1] == m-1:
                    return res-1
                x = q[0][0]
                y = q[0][1]
                for dx, dy in steps:
                    next_x = x + dx
                    next_y = y + dy
                    if next_x > -1 and next_x < n and next_y > -1 and next_y < m and grid[next_x][next_y] == 0:
                        grid[next_x][next_y] = 1
                        q.append((next_x, next_y))
                q.popleft()
        
        return -1