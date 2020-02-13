class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        tag =1
        if(n <1):
            return False
        while(n >= tag):
            if(n % tag ==0):
                return True
            else:
                tag *= 3
        return False