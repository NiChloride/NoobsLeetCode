/*
 * @lc app=leetcode id=79 lang=java
 *
 * [79] Word Search
 */

// @lc code=start
class Solution {
    private int[][] movement = new int[][]{
        {1,0},{0,1},{-1,0},{0,-1}
    };
    
    private int[][] visited;
    
    public boolean exist(char[][] board, String word) {
        if(word.isEmpty()){
            return true;
        }
        
        visited = new int[board.length][board[0].length];
        
        char c = word.charAt(0);
        
        boolean res = false;
        for(int i =0; i<board.length;i++){
            for(int j =0; j<board[0].length;j++){
                int[] pos = new int[]{i,j};
                if(board[i][j] == c && canConstruct(board,word,pos)){
                    res = true;
                    break;
                }
            }
        }
        
        return res;
        
        
    }
    
    boolean canConstruct(char[][] board, String word, int[] pos){
        // System.out.println(Arrays.deepToString(visited));
        if(word.charAt(0) != board[pos[0]][pos[1]]) return false;
        this.visited[pos[0]][pos[1]] = 101;
        word = word.substring(1);
        if(word.isEmpty()) return true;
        boolean res = false;
        for(int i =0; i< movement.length;i++){
            int[] nextPos = new int[2];
            nextPos[0] = pos[0]+movement[i][0];
            nextPos[1] = pos[1]+movement[i][1];
            
            if(nextPos[0]>=0 && nextPos[1]>= 0 && nextPos[0]<board.length && nextPos[1]<board[0].length && this.visited[nextPos[0]][nextPos[1]]!=101 && canConstruct(board,word,nextPos)){
                res = true;
                break;
            }
        }
        this.visited[pos[0]][pos[1]] = 0;
        return res;
        
    }
}
// @lc code=end

