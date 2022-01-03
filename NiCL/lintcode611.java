


/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
//Knight's Shortest Path I bfs
public class Solution {
    /**
     * @param grid: a chessboard included 0 (false) and 1 (true)
     * @param source: a point
     * @param destination: a point
     * @return: the shortest path 
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        int n = grid.length,m = grid[0].length; //dimensions of the grid
        if (n == 0 || m == 0) {
            return -1;
        }
        //directions to take
        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};


        Queue<Point> queue = new LinkedList<>();
        queue.offer(source); //appending starting position to queue

        grid[source.x][source.y] = true; //mark every visited pos as true
        
        int result = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) { //check every position in queue
                Point cur = queue.poll();//pop queue to get the current pos to check
                //if destination is reached, return
                if (cur.x == destination.x && cur.y == destination.y)  {
                    return result;
                }

                //otherwise add all possible next positions to queue
                for (int i = 0; i < 8; i++) {
                    Point next = new Point (
                        cur.x + dx[i],
                        cur.y + dy[i]
                    );
                    //if this next position is valid, add it to the queue
                    if (within_boundary(next,n,m) && grid[next.x][next.y] == false) {
                        queue.offer(next);
                        grid[next.x][next.y] = true;
                    }
                }
            }
            result++;
        }
        return -1;
    }
    //helper function to check whether a point is within boundary
    private boolean within_boundary(Point next,int n,int m) {
        return 0 <= next.x && next.x < n && 0 <= next.y && next.y < m;
    }
}