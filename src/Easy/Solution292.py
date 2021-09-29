#【292】 你和你的朋友，两个人一起玩 Nim 游戏：桌子上有一堆石头，每次你们轮流拿掉 1 - 3 块石头。 拿掉最后一块石头的人就是获胜者。你作为先手。
"""
解析看博文：https://blog.csdn.net/weixin_43071838/article/details/104533872
"""
class Solution292:
    def canWinNim(self, n: int) -> bool:
        return (n % 4) != 0

    def canWinNim2(self, n: int) -> bool:
        return (n & 3) != 0
