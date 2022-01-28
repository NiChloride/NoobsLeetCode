class Solution:
    """
    @param n: a integer
    @return: return a integer
    """
    def countPrimes(self, n):
        from math import sqrt, ceil
        # write your code here
        #Sieve of Eratosthenes
        if n <= 2:
            return 0
        else:
            isP = [None, None]
            isP2 = [True] * (n-2)
            isP = isP + isP2
            print(isP)

            for i in range(2, ceil(sqrt(n))):
                if isP[i] == True:
                    temp = i**2
                    while temp < n:
                        isP[temp] = False
                        temp += i
        
        return isP.count(True)
