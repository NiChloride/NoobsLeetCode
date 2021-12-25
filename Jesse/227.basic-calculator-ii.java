/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */

// @lc code=start
class Solution {
    public int calculate(String s) {
       if(s.length() ==0){
           return Integer.valueOf(s);
       }

       int currentNumber =0, lastNumber = 0;
       int operator = '+';
       int result = 0;
       for(int i =0; i<s.length();i++){
           if(Character.isDigit(s.charAt(i))){
               currentNumber = currentNumber*10 + s.charAt(i)-'0';
           }

           if(!Character.isDigit(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))|| i == s.length()-1){
               if(operator == '+'){
                    result += lastNumber;
                    lastNumber = currentNumber;
                    
               }
               else if(operator == '-'){
                    result += lastNumber;
                    lastNumber = -currentNumber;
               }
               else if(operator == '*'){
                    lastNumber = lastNumber*currentNumber;
               }
               else if(operator == '/'){
                    lastNumber = lastNumber/currentNumber;
               }
               operator=s.charAt(i);
               currentNumber = 0 ;
           }
       }
       result += lastNumber;
       return result;
    }
}
// @lc code=end

