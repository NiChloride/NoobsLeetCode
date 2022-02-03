class Solution:
    """
    @param numbers: Give an array numbers of n integer
    @return: Find all unique triplets in the array which gives the sum of zero.
    """
    def threeSum(self, numbers):
        # write your code here
        if len(numbers) < 3:
            return []

        numbers.sort()

        triplets = []

        Idx1 = 0
        Idx2 = Idx1 + 1
        Idx3 = len(numbers) - 1

        while Idx1 < len(numbers) - 2 and Idx2 < len(numbers) - 1:
            if numbers[Idx1] == numbers[Idx1 - 1]:
                Idx1 += 1
                continue

            Idx2 = Idx1 + 1
            Idx3 = len(numbers) - 1

            while Idx3 > Idx2:
                if Idx3 < len(numbers) - 1:
                    if numbers[Idx3] == numbers[Idx3 + 1]:
                        Idx3 -= 1
                        continue

                temsum = numbers[Idx1] + numbers[Idx2] + numbers[Idx3]

                if temsum == 0:
                    triplets.append([numbers[Idx1], numbers[Idx2], numbers[Idx3]])
                    Idx3 -= 1
                elif temsum > 0:
                    Idx3 -= 1
                elif temsum < 0:
                    Idx2 += 1

            Idx1 += 1
            Idx2 = Idx1 + 1

        return triplets
        
