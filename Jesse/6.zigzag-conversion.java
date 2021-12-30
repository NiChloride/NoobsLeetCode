/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++){
            rows.add(new StringBuilder());
        }
            
        int currentRow =0;
        int delta = -1;
        int changeDircetion = -1;
        for(char c:s.toCharArray()){
            rows.get(currentRow).append(c);
            if(currentRow ==0 || currentRow == numRows-1){
                delta *= changeDircetion;
            }
            
            currentRow += delta;
        }
        
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
        
    }
}
// @lc code=end

