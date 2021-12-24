class Solution:
    def romanToInt(self, s: str) -> int:
        RtI = dict()
        RtI['I'] = 1
        RtI['V'] = 5
        RtI['X'] = 10
        RtI['L'] = 50
        RtI['C'] = 100
        RtI['D'] = 500
        RtI['M'] = 1000
        
        s += 'I'
        #print(s)
        result = 0
        i = 0
        
        while i < len(s) - 1:
            if RtI[s[i+1]]>RtI[s[i]]:
                temp = RtI[s[i+1]] - RtI[s[i]]
                result += temp
                i += 2
            else:
                result += RtI[s[i]]
                i += 1
        
        print(result)
        return result
