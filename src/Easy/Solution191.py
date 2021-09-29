#【191】位1的个数
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
class Solution:
    def hammingWeight(self, n: int) -> int:
        return bin(n).count('1')

    def hammingWeight(self, n: int) -> int:
        count = 0
        while n > 0:
            n &= (n - 1)
            count += 1
        return count


x = 10000
print(type(bin(x)), " ", bin(x))


