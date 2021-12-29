class Solution {
public:
    /**
     * @param string: A string
     * @return: whether the string is a valid parentheses
     */
    bool matchParentheses(string &str) {
        string ans="";
        for(auto i:str)
        {
            if(i=='(')
              ans+=i;
            else{
                if(ans.size()==0) return false;
                if(ans[ans.size()-1]=='(' && i==')') ans.pop_back();
                else return false;
            }  
        }
        if(ans.size()==0) return true;
        return false;
    }
};