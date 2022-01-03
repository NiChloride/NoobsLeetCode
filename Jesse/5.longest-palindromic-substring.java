/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    public String longestPalindrome(String s) {
        
        int[][] dpArr = new int[s.length()][s.length()];
        
        int start =0, end =0;
        
        for(int i =0; i<s.length();i++){
            for(int j=i;j>=0;j--){
                if(j == i){
                    dpArr[j][i] = 1;
                }
                else if(i-j == 1 && s.charAt(i) == s.charAt(j)){
                    dpArr[j][i] = 1;
                }
                else if(s.charAt(i) == s.charAt(j) && dpArr[j+1][i-1] == 1){
                    dpArr[j][i] = 1;
                }
                else{
                    dpArr[j][i] = 0;
                }
                
                if(dpArr[j][i] == 1 && i-j>end-start){
                    start = j;
                    end = i;
                }
            }
                
        }
        
        
        
        return s.substring(start, end+1);
        
    }
}
// @lc code=end

