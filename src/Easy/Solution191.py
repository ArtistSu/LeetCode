class Solution:
    def hammingWeight(self, n: int) -> int:
        return bin(n).count('1')


x = 10000
print(type(bin(x)), " ", bin(x))
