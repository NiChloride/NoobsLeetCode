/*
 * @lc app=leetcode id=139 lang=java
 *
 * [139] Word Break
 */

// @lc code=start
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Boolean> helper = new HashMap<>();
        
        return check(s,wordDict,helper);
    }
    
    boolean check(String target,List<String> wordDict, Map<String,Boolean> helper){
        
        if(helper.containsKey(target)){
            return helper.get(target);
        }
        
        if(target.isEmpty()){
            return true;
        }
       
        for(String word:wordDict){
            if(target.startsWith(word)){
                if(check(target.substring(word.length()),wordDict,helper)){
                    helper.put(target,true);
                    return true;
                }
            }
        }
        
            
        helper.put(target,false);
        return false;
    }
}
// @lc code=end

