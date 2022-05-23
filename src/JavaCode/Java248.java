package JavaCode;

public class Java248 {
    /**
     * Time Complexity: O(n) {@code n} is the length of {@param nums}
     * Space Complexity: O(n)
     *
     * @param nums
     * @param k
     * @return
     * @method prefix sum
     * @topic Count Number of Nice Subarrays
     * @author ArtistS
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        // nums 长度小于 k 个数直接返回
        if (len < k) {
            return 0;
        }
        // 当前节点到下表为 0(也就是起始点)有多少个奇数
        int[] prefixSum = new int[len];
        // 统计前面为 i个数 的子串有多少个 是下标
        int[] cnt = new int[len + 1];
        cnt[0] = 1;
        int prev = 0;
        for (int i = 0; i < len; i++) {
            // 因为奇数转化成 2 进制肯定最后一位是 1, 只有 1&1 才是 1, 0&1 就是 0. 比如 3 它的 2 进制就是
            // 11 = 1*2 + 1*2^0= 3 所以 11 & 000001 = 1(因为 1 的二进制是 1, 前面都是 0)
            // 我们的目的就是如果当前这个数是奇数, 那么我们就在对应的统计数组 prefixSum 对应的下标+1, 如果是偶数就是
            // prefiSum[i-1]
            // 如果看不懂你就 if(nums[i]%2!=0){prefixSum[i] = prefixSum[i-1]+1} 要注意别越界 这里就是说明
            prefixSum[i] = prev + (nums[i] & 1);
            prev = prefixSum[i];

            // 很多人这看不到 为什么是 当前奇数个数 - k 个就是 子串中奇数为 k的个数
            // 假设当前奇数个数是 5, 我们要找 k 个. 注意 这个是 prefixSum, 带到这里面去想. 所以下标为 5-k 就说明 从下标
            // 5-k 到 k 这段里面有 k 个奇数. 但是这个只是答案之一, 我们要做的是 有多少个像 下标 5-k 到 k 中 有 k 个奇数的
            // 片段. 这是关键, 先想明白这个. 假如你的 prefixSum 是 0112345, 总共 7 个数 从下标 i=4 到i=6 就是有 3 个奇数.
            // 至于像这样的片段有多少是下一个问题

            // 第二个问题 为什么会有 cnt[当前节点之前的奇数总和 - k] 个这样的片段
            // prefixSum 代码 9 行我说了, 我们要求的是有多少 prefixSum[i] - prefixSum[j] = k. 是有多少个这样的表达式存在
            // 现在为什么要变换这个式子为 prefixSum[j] = prefixSum[i]-k, k已知的, prefixSum[i]表达的是下标为 i到下标为 0
            // 的所有奇数的总和, 那么现在我们不就是要求 how many prefixSum[j] = C, C=prefixSum[i]-k. cnt就是干这个的
            // 就是用来记录 how many 存在一个片段使前面奇数和为 i 我们就在对应的 cnt[i]上+1; 为什么cnt 是 len+1, 因为如果
            // 全都是奇数, 那么就会有 len 个. cnt[len] 直接越界
            // 不要去想 为什么会有减去 k 个子串, 你想的那个东西是 prefixSum, 而运行的是 cnt
            if (prefixSum[i] >= k) {
                res += cnt[prefixSum[i] - k];
            }
            ;
            cnt[prefixSum[i]] += 1;
        }
        return res;
    }

}
