class Solution:
    def myAtoi(self, s: str) -> int:
        s = s.strip()
        print(s)
        out=""
        if s == "":
            return 0
        
        if len(s) < 2:
            if not s.isnumeric():
                return 0
            else:
                return s
        
        if s[0] != "-" and s[0] != "+" and s[0].isnumeric() == False:
            return 0
        else:
            out += s[0]
            if not s[1].isnumeric():
                if out.isnumeric():
                    return out
                else:
                    return 0
                
            for i in range(1,len(s)):
                if not s[i].isnumeric():
                    break
                out += s[i]
            out = int(out)
            print(out)
            if out > (2**31)-1:
                out = (2**31)-1
            elif out < -(2**31):
                out = -(2**31)
            return int(out)
