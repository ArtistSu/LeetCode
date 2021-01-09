import re
import sys
import math

"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
class Solution:
    def myAtoi(self, str: str) -> int:
        return max(min(int(*re.findall('^[\+\-]?\d+', str.lstrip())), 2 ** 31 - 1), -2 ** 31)

    def myAtoi2(self, str: str) -> int:
        return max(min(int(*re.findall('^[\+\-]?\d+', str.lstrip())), (1 << 31) - 1), -1 << 31)

    def myAtoi3(self, str: str) -> int:
        return int(*re.findall('^[\+\-]?\d+', str.lstrip()))

    def myAtoi4(self, str: str) -> int:
        return int(re.findall('^[\+\-]?\d+', str.lstrip()))


s = Solution()

print(sys.getsizeof(sys.maxsize))
print(sys.maxsize)
print(math.log2(sys.maxsize))
print(2**63-1)
