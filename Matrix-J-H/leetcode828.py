#2020/02/15
class Solution:
    def uniqueLetterString(self, s):
        n, res = len(s), 0
        lastSeenIndices = defaultdict(lambda: None)

        P = 0 # P is the accumulate count for each ith step
        res = 0

        for i in range(len(s)):

            if not lastSeenIndices[s[i]]:
                newP = P + i + 1
                lastSeenIndices[s[i]] = (-1, i)
            else:
                scdLastSeen, lastSeen = lastSeenIndices[s[i]]
                # Q is the substrings does not contain s[i] in slice s[:i]
                Q = i - 1 - lastSeen
                # R is the substrings contain only one s[i] in slice s[:i]
                R = lastSeen - scdLastSeen
                newP = P + Q - R + 1 
                lastSeenIndices[s[i]] = (lastSeen, i)

            res += newP
            P = newP

        return res
