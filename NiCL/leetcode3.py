class Solution:
    def lengthOfLongestSubstring(self,s: str) -> int:
        if not s:
            return 0
        contains = {s[0]:0} #a map used to judge whether a character is in the current substring being assessed, 
        #documents the position of each character as well
        #encounteredDuplicate = False #indicates whether a non-duplicate substring has ended, set to true when the first
        #duplicated character is found, set to false whenever a new assessment begins
        cur_best = 1 #the current best result
        #cur_len = 0 #length of the substring being assessed
        #DP[i] = last_known_position to i or DP[i-1] + 1
        DP = [1] #best result for when the substring at [0, i] is input
        for i in range(1,len(s)):
            #when encountering a duplicate
            if s[i] in contains:
                #update DP[i]
                DP.append(i - contains[s[i]])
                newStart = contains[s[i]]+1
                #print(s[i], "exists")
                #update contains
                contains = {}
                for idx in range(newStart, i+1):
                    contains[s[idx]] = idx
            else:
                contains[s[i]] = i
                print(contains)
                DP.append(DP[i-1]+1)
                if(DP[i]>cur_best):
                    cur_best=DP[i]
        return cur_best
