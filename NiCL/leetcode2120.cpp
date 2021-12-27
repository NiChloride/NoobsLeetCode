// 2120. Execution of All Suffix Instructions Staying in a Grid
// naive solution


class Solution {
    public:
    vector<int> executeInstructions(int n, vector<int>& startPos, string s) {
        int m = s.length();
        vector<int> ans;
        for (int m1 =0;m1<m;m1++){
            int x = startPos[0];
            int y = startPos[1];
            int count = 0;
            for(int i=m1;i<m;i++)
            {
                if(s[i] == 'U')
                {
                    if(x == 0){
                        break;
                    }
                    x--;
                }
                if (s[i]=='D')
                {
                    if(x==n-1){
                        break;
                    }
                    x++;
                }
                if(s[i] =='L')
                {
                    if(y == 0){
                        break;
                    }
                    y--;
                }
                if(s[i] =='R')
                {
                    if(y == n-1)
                    {
                        break;
                    }
                    y++;
                
                    
                }
                    count++;
            }
                ans.push_back(count);
        }
        return ans;
    }
}