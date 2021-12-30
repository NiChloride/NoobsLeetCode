/*
 * @lc app=leetcode id=22 lang=java
 *
 * [22] Generate Parentheses
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans= new ArrayList<>();
        construction(ans,new StringBuilder(), 0,0,n);
        return ans;
    }
    
    void construction(List<String> ans, StringBuilder sb, int open, int close, int max){
        if(sb.length() == 2*max){
            ans.add(sb.toString());
            return;
        }
        
        if(open < max){
            sb.append("(");
            construction(ans,sb,open+1,close,max);
            sb.deleteCharAt(sb.length()-1);
            
        }
        if(close < open){
            sb.append(")");
            construction(ans,sb,open,close+1,max);
            sb.deleteCharAt(sb.length()-1);
        }
        
        
    }
}
// @lc code=end

