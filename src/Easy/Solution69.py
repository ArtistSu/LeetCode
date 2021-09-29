# 【69】计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
import math
from math import e, log


class Solution69:
    def mySqrt(self, x: int) -> int:
        return int((math.sqrt(x)))

    def mySqrt2(self, x: int) -> int:
        if x < 2:
            return x
        left = int(e ** (0.5 * log(x)))
        right = left + 1
        if right * right > x:
            return left
        else:
            return right

    def mySqrt3(self, x: int) -> int:
        if x <= 2:
            return x
        left, right = 2, x // 2
        while left <= right:
            guess_digit = left + (right - left) // 2
            num = guess_digit ** 2
            if num > x:
                right = guess_digit -1
            elif num < x:
                left = guess_digit
            else:
                return guess_digit
        return right
s = Solution69()
print(s.mySqrt(3))
