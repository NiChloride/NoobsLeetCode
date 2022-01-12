/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(c == '{' || c == '[' || c == '('){
                stack.push(c);
             }
            else{
                if(stack.isEmpty()) return false;
                char temp = stack.pop();
                if(temp == '{' && c != '}'){
                    return false;
                }
                if(temp == '[' && c != ']'){
                    return false;
                }
                if(temp == '(' && c != ')'){
                    return false;
                }
            }
                                   
        }
        
        if(!stack.isEmpty()) return false;
        return true;
    }
}
// @lc code=end

