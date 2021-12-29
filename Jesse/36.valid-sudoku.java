/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character,ArrayList<int[]>> table = new HashMap<>();
        
        for(int i =0;i<9;i++){
            for(int j =0; j<9;j++){
                char c = board[i][j];
                if(Character.isDigit(c)){
                    int[] temp = new int[]{i,j};
                    ArrayList<int[]> list = table.getOrDefault(c,new ArrayList<int[]>());
                    if(list.size() == 0){
                        list.add(temp);
                        table.put(c,list);
                    }
                    else{
                        for(int[] array : list){
                            if(!validation(array,temp)){
                                return false;
                            }
                        }
                        table.get(c).add(temp);
                    }
                    
                }
            }
        }
        
        return true;
    }
    
    boolean validation(int[] arr1, int[] arr2){
        if(arr1[0] == arr2[0] || arr1[1] == arr2[1]) return false;
        if((arr1[0])/3 == (arr2[0])/3 && (arr1[1])/3 == (arr2[1])/3) return false;
        return true;
    }
}
// @lc code=end

