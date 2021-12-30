#include <deque>

class Solution {
public:
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
      bool match(char a,char b)
        {
           return a=='['&&b==']'||a=='{'&&b=='}'||a=='('&&b==')';
        }
    bool isValidParentheses(string &s) {
        // write your code here
        string  k;
       for(int i=0;i<s.size();i++)
       {
           if(s[i]==']'||s[i]=='}'||s[i]==')')
             {
                 if(k.empty()||!match(k.back(),s[i]))
                  return false;
                  k.pop_back();
             }
             else
               k.push_back(s[i]);
       }
       return k.empty();
       


    }
};