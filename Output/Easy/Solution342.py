# 【342】4的幂
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""


class Powers:
    def __init__(self):
        max_power = 15
        self.nums = nums = [1] * (max_power + 1)
        for i in range(1, max_power + 1):
            nums[i] = 4 * nums[i - 1]


class Solution342:
    def isPowerOfFour(self, num: int) -> bool:
        temp = 1
        if num < temp:
            return False
        while temp <= num:
            if num == temp:
                return True
            temp = temp * 4
        return False

    def isPowerOfFour2(self, num: int) -> bool:
        temp = [1]
        for i in range(1, 16):
            # if num < temp[i - 1]:
            #     return False
            temp.append(4 ** i)
            print(i)
            if temp[i] == num:
                return True
        return False

    def isPowerOfFour3(self, num: int) -> bool:
        p = Powers()
        return num in self.p.nums

    def isPowerOfFour4(self, num: int) -> bool:
        return num > 0 and num & (num - 1) == 0 and num & 0xaaaaaaaa == 0

    def isPowerOfFour5(self, num: int) -> bool:
        if num < 0 or num & (num - 1):
            return False
        return num & 0x55555555;


s = Solution342()
s.isPowerOfFour2(3)
