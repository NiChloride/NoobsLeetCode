import java.util.List;

/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */

// @lc code=start
class Solution {
    Map<String,List<Integer>> memo = new HashMap<>();
    
   public List<Integer> diffWaysToCompute(String expression) {
           
        if(this.memo.containsKey(expression)){
            return this.memo.get(expression);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i =0; i< expression.length();i++){
            if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*'){
                String part1 = expression.substring(0,i);
                String part2 = expression.substring(i+1);
                List<Integer> p1Res = diffWaysToCompute(part1);
                List<Integer> p2Res = diffWaysToCompute(part2);

                for(int p1 : p1Res){
                    for(int p2:p2Res){
                        int temp = 0;
                        switch (expression.charAt(i)) {
                            case '+':
                                temp = p1+p2;
                                break;
                            case '-':
                                temp = p1-p2;
                                break;
                            case '*':
                                temp = p1*p2;
                                break;
                        }
                        res.add(temp);
                    }
                }

                
            }
        }

        if(isDigit(expression)){
            res.add(Integer.valueOf(expression));
        }
           
        this.memo.put(expression,res);
        

        return res;
    }

    boolean isDigit(String s){
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

