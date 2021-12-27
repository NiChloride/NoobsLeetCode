class Solution:
    #helper function
    def reverseInteger (self, num: int) -> int:
        if num<10:
            return num
        str_num = str(num)
        str_num = str_num[::-1]
        reversed_num = int(str_num)
        return reversed_num
        
    def isSameAfterReversals(self, num: int) -> bool:
        double_reversed = self.reverseInteger(self.reverseInteger(num))
        return double_reversed == num