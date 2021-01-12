# 【231】给定一个整数，编写一个函数来判断它是否是 2 的幂次方
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
class Solution:
    """
    题目分析：这个大白话，我觉得大家都看的懂。怎么搞呢？最简单的就是一遍遍乘看结果，跟一遍遍取模一个道理，就像这样：
    """

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

    """
    这个代码不解释了，要是看不懂em……木得办法了。接下来说一下如何优化这个东西，这就又要涉及到位运算了，这里说个结论：一个数是不是2的幂次方
    就看这个数 与运算 这个数减1 是不是0。 这个结论怎么得出来的呢，其实很好想，与运算1&0是0，1&1是1。我们设想4 它的2进制是0100，3的二进制
    是0011，5的二进制是0101。那么现在来看从5到4一定是少了最末位的1，因为2^0是1，所以无论增减2进制都是要在最后一位进行操作。我们来看一下这
    个命令 1<<31 左移31位，每左移一次就是乘2，想一下是不是从1->10->100->1000……而他们减1 是不是0 ->01->011->0111……。所以这个问题就很
    明了了，知道这个这个代码就变成了：
    """

    def isPowerOfTwo_2(self, n: int) -> bool:
        if (n <= 0):
            return False
        return n & (n - 1) == 0
    """
    再来说另外一种我看到的，**还是先说结论：这个数y是2的幂次方，那么y&(-y)一定是y。**为啥咧？这就涉及到补码的问题，大家可以自己百度，整体
    的思路就跟上面我说的与运算差不多。代码如下：
    """
    def isPowerOfTwo_3(self, n: int) -> bool:
        if (n <= 0):
            return False
        return n & (-n) == n