# 【268】给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""


class Solution268:
    def missingNumber(self, nums) -> int:
        temp = max(nums) + 1
        for i in range(0, temp):
            if not (i in nums):
                return i
        return temp

    def missingNumber2(self, nums):
        missing = len(nums)
        for i, num in enumerate(nums):
            missing ^= i ^ num
        return missing

    def missingNumber3(self, nums):
        return sum(range(len(nums) + 1)) - sum(nums)
