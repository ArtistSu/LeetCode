#【326】给定一个整数，写一个函数来判断它是否是 3 的幂次方。
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
class Solution326:
    """
    题目解析：从大意上来看这道题跟231很像，一个是看是否是2的幂次方，一个是看3的幂次方。
    首先看到这个题的第一个想法，还是采取乘法判断的方法，这是一个求幂次方的通用解法，不赘述直接看代码：
    """
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