/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 */

// @lc code=start
class Solution {
    String digits;
    Map<Character,char[]> keyboard = new HashMap<>();
    
    public List<String> letterCombinations(String digits) {
        if(digits.equals(null)|| digits.length() ==0){
            return new ArrayList<String>();
        }
        this.digits = digits;
        
        this.keyboard.put('2',new char[]{'a','b','c'});
        this.keyboard.put('3',new char[]{'d','e','f'});
        this.keyboard.put('4',new char[]{'g','h','i'});
        this.keyboard.put('5',new char[]{'j','k','l'});
        this.keyboard.put('6',new char[]{'m','n','o'});
        this.keyboard.put('7',new char[]{'p','q','r','s'});
        this.keyboard.put('8',new char[]{'t','u','v'});
        this.keyboard.put('9',new char[]{'w','x','y','z'});
        
        List<String> res = new ArrayList<>();
        backtracking(res,new StringBuilder(),0);
        return res;
        
    }
    
    void backtracking(List<String> res, StringBuilder current, int idx){
        if(idx == this.digits.length()){
            res.add(current.toString());
            return;
        }
        
        for(char c : this.keyboard.get(this.digits.charAt(idx))){
            current.append(c);
            backtracking(res,current,idx+1);
            current.deleteCharAt(current.length()-1);
        }
        
    }
}
// @lc code=end

