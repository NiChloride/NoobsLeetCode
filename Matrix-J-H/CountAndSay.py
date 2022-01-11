```
The count-and-say sequence is a sequence of digit strings defined by the recursive formula:

countAndSay(1) = "1"
countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, replace the counts with a number and concatenate every saying.

For example, the saying and conversion for digit string "3322251":
23321511

Given a positive integer n, return the nth term of the count-and-say sequence.
```

#This is somehow wrong

class Solution:
    def countAndSay(self, n: int) -> str:
        if n == 1:
            return "1"
        
        txt = self.countAndSay(n-1)
        temp = self.makelist(txt)
        for i in range(len(temp)):
            temp[i] = str(len(temp[i]))+ temp[i][0]
        print(temp)
        out = ''.join(temp)    
        return out
        
    def makelist(self,txt):
        lst = []
        pre = ''
        for l in txt:
            if l == pre:
                lst[-1] += l
            else:
                lst.append(l)
        return lst
