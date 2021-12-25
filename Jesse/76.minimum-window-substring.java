import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 */

// @lc code=start
class Solution {
    public String minWindow(String s, String t) {
       if(s.length() == 0 || t.length() ==0){
           return "";
       }

       Map<Character,Integer> tbd = new HashMap<>();

       for(int i =0; i<t.length(); i ++){
           int count = tbd.getOrDefault(t.charAt(i), 0);
           tbd.put(t.charAt(i), count+1);
       }

       int required = tbd.size();

        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tbd.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }
        int left = 0, right =0, get =0;
        Map<Character,Integer> temp = new HashMap<>();
        int[] ans = {Integer.MAX_VALUE, 0, 0};

        while (right < filteredS.size()){
            char c = filteredS.get(right).getValue();
            if(tbd.containsKey(c)){
                int count = temp.getOrDefault(c, 0);
                temp.put(c, count+1);
                if(temp.get(c).intValue() == tbd.get(c).intValue()){
                    get +=1;
                }
                System.out.println(get);
                while(left<=right && get == required){
                    c = filteredS.get(left).getValue();
                    int start = filteredS.get(left).getKey();
                    int end = filteredS.get(right).getKey();
                    if(ans[0] > end-start+1){
                        ans[0] = end-start+1;
                        ans[1] = start;
                        ans[2] = end;
                    }

                    temp.put(c, temp.get(c)-1);
                    if(temp.get(c) < tbd.get(c)){
                        get--;
                    }
                    left++;
                }

            

            }
            right++;
        }
        return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
// @lc code=end

