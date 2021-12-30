/*
 * @lc app=leetcode id=54 lang=java
 *
 * [54] Spiral Matrix
 */

// @lc code=start
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] movement = new int[][]{
            {0,1},{1,0},{0,-1},{-1,0}
        };
        
        int direction = 0;
        int[][] visited = new int[matrix.length][matrix[0].length];
        List<Integer> answer = new ArrayList<>();
        
        int size = matrix.length*matrix[0].length;
        int[] pos = new int[]{0,0};
        for(int i =0;i<size;i++){
            answer.add(matrix[pos[0]][pos[1]]);
            visited[pos[0]][pos[1]] = 1;
            int[] nextPos = new int[2];
            nextPos[0] = pos[0] + movement[direction][0];
            nextPos[1] = pos[1] + movement[direction][1];
            
            if(nextPos[0]>=0 && nextPos[1]>=0 && nextPos[0]<matrix.length && nextPos[1]<matrix[0].length && visited[nextPos[0]][nextPos[1]] != 1){
                pos = nextPos;
            }
            else{
                if(direction != 3){
                    direction++;
                }
                else{
                    direction =0;
                }
                pos[0] += movement[direction][0];
                pos[1] += movement[direction][1];
            }
        }
        
        return answer;
    }
}
// @lc code=end

