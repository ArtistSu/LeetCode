class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        tag = 1
        if (n < 0):
            return False
        while (n >= tag):
            if (n == tag):
                return True
            else:
                tag *= 2
        return False

    def isPowerOfTwo_2(self, n: int) -> bool:
        if (n <= 0):
            return False
        return n & (-n) == n

    def isPowerOfTwo_3(self, n: int) -> bool:
        if (n <= 0):
            return False
        return n & (n - 1) == 0
