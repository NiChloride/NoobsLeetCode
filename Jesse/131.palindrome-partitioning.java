/*
 * @lc app=leetcode id=131 lang=java
 *
 * [131] Palindrome Partitioning
 */

// @lc code=start
class Solution {
    void backtracking(List<List<String>> res, LinkedList<String> current,String s, int[][] dp, int start){
        if(start>=s.length()){
            res.add(new ArrayList<String>(current));
        } 
        for(int mid = start;mid<s.length();mid++){
            String left = s.substring(start,mid+1);
            
            if(isPalindrome(left)||dp[start][mid+1] == 1){
                current.addLast(left);
                dp[start][mid+1] = 1;
                backtracking(res,current,s,dp,mid+1);
                current.removeLast();
            }
        }
        
    }
    
    boolean isPalindrome(String s){
        int i =0,j = s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        int[][] dp = new int[s.length()+1][s.length()+1];
        backtracking(res,new LinkedList<String>(),s,dp,0);
        return res;
    }
}
// @lc code=end

