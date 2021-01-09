#【258】给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
class Solution258:
    def addDigits(self, num: int) -> int:
        while num > 10:
            digit = list(map(int, str(num)))
            num = 0
            for i in range(len(digit)):
                num += digit[i]
        return num

    def addDigits2(self, num: int) -> int:
        if (num % 9 == 0) and (num != 0):
            return 9
        else:
            return num % 9

    def addDigits3(self, num: int) -> int:
        while num >= 10:
            sum = 0
            while num > 0:
                sum += num % 10
                num //= 10
            num = sum
        return num


s = Solution258()
print(s.addDigits3(38))
