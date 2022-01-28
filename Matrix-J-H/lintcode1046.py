class Solution:
    """
    @param L: an integer
    @param R: an integer
    @return: the count of numbers in the range [L, R] having a prime number of set bits in their binary representation
    """
    def countPrimeSetBits(self, L, R):
        # Write your code here
        # in binary, 1m has 20

        primeNumbers = [2, 3, 5, 7, 11, 13, 17, 19]
        from math import log2, floor
        counter = 0

        for i in range(L, R+1):
            ''' 
            #calculate binary by hand
            binary = 0

            while i > 1:
                b1 = floor(log2(i))
                print(b1)
                binary += 10**b1
                i = i - 2**b1

            binary += i
            '''
            
            binary = bin(i)
            binary = str(binary)

            sb = binary.count('1')
            if sb in primeNumbers:
                counter += 1
        
        return counter
